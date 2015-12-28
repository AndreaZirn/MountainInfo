package mountains.model;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class MountainListModel {

    private static final String FILE_NAME = "mountains.csv";

    private final IntegerProperty selectedMountainId  = new SimpleIntegerProperty(-1);
    private final IntegerProperty selectedIndex     = new SimpleIntegerProperty(-1);

    private final ObservableList<Command> undoStack = FXCollections.observableArrayList();
    private final ObservableList<Command> redoStack = FXCollections.observableArrayList();

    private final BooleanProperty undoDisabled = new SimpleBooleanProperty();
    private final BooleanProperty redoDisabled = new SimpleBooleanProperty();

    private final ObservableList<Mountain> mountains = FXCollections.observableArrayList();

    private final Mountain mountainProxy = new Mountain();


    private final ChangeListener<Object> propertyChangeListenerForUndoSupport = (observable, oldValue, newValue) -> {
        redoStack.clear();
        undoStack.add(0, new ValueChangeCommand(MountainListModel.this, (Property) observable, oldValue, newValue));
    };


    public MountainListModel() {
        mountains.addAll(readFromFile());

        undoDisabled.bind(Bindings.isEmpty(undoStack));
        redoDisabled.bind(Bindings.isEmpty(redoStack));


        selectedMountainIdProperty().addListener((observable1, oldId, newId) -> {
            try {
                setSelectedIndex(mountains.indexOf(getMountain((Integer) newId)));
            } catch (Exception e) {
                setSelectedIndex(-1);
            }
        });

        selectedIndexProperty().addListener((observable1, oldValue1, newIndex) -> {
            try {
                setSelectedMountainId(mountains.get((Integer) newIndex).getId());
            } catch (Exception e) {
                setSelectedMountainId(-1);
            }
        });

        //Selectionhandling
        selectedMountainIdProperty().addListener((observable, oldValue, newValue) -> {
                    Mountain oldSelection = getMountain((int) oldValue);
                    Mountain newSelection = getMountain((int) newValue);

                    if (oldSelection != null) {
                        unbindFromProxy(oldSelection);
                        disableUndoSupport(oldSelection);
                    }

                    if (newSelection != null) {
                        bindToProxy(newSelection);
                        enableUndoSupport(newSelection);
                    }
                }
        );
        setSelectedMountainId(0);

    }



    public ObservableList<Mountain> getMountains() {
        return mountains;
    }

    public Mountain getMountainProxy() {
        return mountainProxy;
    }

    public Mountain getMountain(int id) {
        Optional<Mountain> pmOptional = mountains.stream()
                .filter(mountain -> mountain.getId() == id)
                .findAny();
        return pmOptional.isPresent() ? pmOptional.get() : null;
    }


    public void addNewMountain() {
        int newId = mountains.stream()
                .map(m -> {return m.getId();})
                .max((id1, id2) -> { return id1.compareTo(id2); })
                .get();
        newId = newId +1;

        Mountain newMountain = new Mountain();
        newMountain.setId(newId);

        addToList(newMountain);

        redoStack.clear();
        undoStack.add(0, new AddCommand(this, newMountain, mountains.size() - 1));
    }

    public void removeMountain() {
        Mountain toBeRemoved = getMountain(getSelectedMountainId());
        int currentPosition = mountains.indexOf(toBeRemoved);

        removeFromList(toBeRemoved);

        redoStack.clear();
        undoStack.add(0, new RemoveCommand(this, toBeRemoved, currentPosition));
        setSelectedMountainId(mountains.get(0).getId());
    }

    public void setPropertyValue(Property property, Object newValue) {
        property.removeListener(propertyChangeListenerForUndoSupport);
        property.setValue(newValue);
        property.addListener(propertyChangeListenerForUndoSupport);
    }


    public void addToList(Mountain mountain){
        mountains.add(mountain);
        setSelectedMountainId(mountain.getId());
    }

    public void removeFromList(Mountain mountain){
        unbindFromProxy(mountain);
        disableUndoSupport(mountain);

        mountains.remove(mountain);

        if(!mountains.isEmpty()){
            setSelectedMountainId(mountains.get(0).getId());
        }
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command cmd = undoStack.get(0);
        undoStack.remove(0);
        redoStack.add(0, cmd);

        cmd.undo();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command cmd = redoStack.get(0);
        redoStack.remove(0);
        undoStack.add(0, cmd);

        cmd.redo();
    }

    private void disableUndoSupport(Mountain mountain) {
        //ImageHandling
        mountain.imagePropertyProperty().removeListener(propertyChangeListenerForUndoSupport);

        mountain.idProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.nameProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.hoeheProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.dominanzProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.schartenhoeheProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.kmBisProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.mBisProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.typProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.regionProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.kantonProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.gebietProperty().removeListener(propertyChangeListenerForUndoSupport);
        mountain.bildunterschriftProperty().removeListener(propertyChangeListenerForUndoSupport);
    }

    private void enableUndoSupport(Mountain mountain) {
        //ImageHandling
        mountain.imagePropertyProperty().addListener(propertyChangeListenerForUndoSupport);

        mountain.idProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.nameProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.hoeheProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.dominanzProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.schartenhoeheProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.kmBisProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.mBisProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.typProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.regionProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.kantonProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.gebietProperty().addListener(propertyChangeListenerForUndoSupport);
        mountain.bildunterschriftProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private void bindToProxy(Mountain mountain) {
        //ImageHandling
        mountainProxy.imagePropertyProperty().bindBidirectional(mountain.imagePropertyProperty());

        mountainProxy.idProperty().bindBidirectional(mountain.idProperty());
        mountainProxy.nameProperty().bindBidirectional(mountain.nameProperty());
        mountainProxy.hoeheProperty().bindBidirectional(mountain.hoeheProperty());
        mountainProxy.dominanzProperty().bindBidirectional(mountain.dominanzProperty());
        mountainProxy.schartenhoeheProperty().bindBidirectional(mountain.schartenhoeheProperty());
        mountainProxy.kmBisProperty().bindBidirectional(mountain.kmBisProperty());
        mountainProxy.mBisProperty().bindBidirectional(mountain.mBisProperty());
        mountainProxy.typProperty().bindBidirectional(mountain.typProperty());
        mountainProxy.regionProperty().bindBidirectional(mountain.regionProperty());
        mountainProxy.kantonProperty().bindBidirectional(mountain.kantonProperty());
        mountainProxy.gebietProperty().bindBidirectional(mountain.gebietProperty());
        mountainProxy.bildunterschriftProperty().bindBidirectional(mountain.bildunterschriftProperty());
    }

    private void unbindFromProxy(Mountain mountain) {
        //ImageHandling
        mountainProxy.imagePropertyProperty().unbindBidirectional(mountain.imagePropertyProperty());

        mountainProxy.idProperty().unbindBidirectional(mountain.idProperty());
        mountainProxy.nameProperty().unbindBidirectional(mountain.nameProperty());
        mountainProxy.hoeheProperty().unbindBidirectional(mountain.hoeheProperty());
        mountainProxy.dominanzProperty().unbindBidirectional(mountain.dominanzProperty());
        mountainProxy.schartenhoeheProperty().unbindBidirectional(mountain.schartenhoeheProperty());
        mountainProxy.kmBisProperty().unbindBidirectional(mountain.kmBisProperty());
        mountainProxy.mBisProperty().unbindBidirectional(mountain.mBisProperty());
        mountainProxy.typProperty().unbindBidirectional(mountain.typProperty());
        mountainProxy.regionProperty().unbindBidirectional(mountain.regionProperty());
        mountainProxy.kantonProperty().unbindBidirectional(mountain.kantonProperty());
        mountainProxy.gebietProperty().unbindBidirectional(mountain.gebietProperty());
        mountainProxy.bildunterschriftProperty().unbindBidirectional(mountain.bildunterschriftProperty());
    }


    public void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
            writer.write("ID;Name;Dominanz;Schartenhoehe;Hoehe;km bis;m bis;Typ;Region;Kanton;Gebiet;Bildunterschrift");
            writer.newLine();
            mountains.stream().forEach(mountain -> {
                try {
                    writer.write(mountain.infoAsLine());
                    writer.newLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }


    private List<Mountain> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            return stream
                    .map(s -> new Mountain(s.split(";")))      // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());            // alles aufsammeln
        }
    }

    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName, true), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String fileName, boolean locatedInSameFolder)  {
        try {
            if(!locatedInSameFolder) {
                fileName = "/" + fileName;
            }else{
                fileName = "data/" + FILE_NAME;
            }
            return Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public int getSelectedIndex() {
        return selectedIndex.get();
    }

    public IntegerProperty selectedIndexProperty() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex.set(selectedIndex);
    }

    public int getSelectedMountainId() {
        return selectedMountainId.get();
    }

    public IntegerProperty selectedMountainIdProperty() {
        return selectedMountainId;
    }

    public void setSelectedMountainId(int selectedMountainId) {
        this.selectedMountainId.set(selectedMountainId);
    }

    public boolean getUndoDisabled() {
        return undoDisabled.get();
    }

    public BooleanProperty undoDisabledProperty() {
        return undoDisabled;
    }

    public void setUndoDisabled(boolean undoDisabled) {
        this.undoDisabled.set(undoDisabled);
    }

    public boolean getRedoDisabled() {
        return redoDisabled.get();
    }

    public BooleanProperty redoDisabledProperty() {
        return redoDisabled;
    }

    public void setRedoDisabled(boolean redoDisabled) {
        this.redoDisabled.set(redoDisabled);
    }


}
