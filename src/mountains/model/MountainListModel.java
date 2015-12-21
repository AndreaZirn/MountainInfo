package mountains.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class MountainListModel {

    private static final String FILE_NAME = "mountains.csv";

    private final StringProperty applicationTitle = new SimpleStringProperty("Swiss Mountains");

    private final ObservableList<Mountain> mountains = FXCollections.observableArrayList();


    public MountainListModel() {
        mountains.addAll(readFromFile());
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
            return stream.skip(1)                              // erste Zeile ist die Headerzeile; ueberspringen
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

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public ObservableList<Mountain> getMountain() {
        return mountains;
    }

}
