package mountains.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import mountains.model.MountainListModel;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class Navigation extends HBox implements ViewMixin<MountainListModel>{

    private final MountainListModel mountainlist;

    private Button addButton;
    private Button deleteButton;
    private Button redoButton;
    private Button undoButton;
    private Button saveButton;
    private TextField filterField;

    public Navigation(MountainListModel mountainlist) {
        this.mountainlist = mountainlist;
        getStyleClass().add("buttonbar");
        init();
    }

    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }
    @Override
    public void initializeControls() {
        addButton = new Button("add");
        deleteButton = new Button("delete");
        redoButton = new Button("redo");
        undoButton = new Button("undo");
        saveButton = new Button("save");
        filterField = new TextField("search");
    }

    @Override
    public void layoutControls() {
        setPadding(new Insets(10));
        setSpacing(6);
        getChildren().addAll(addButton, deleteButton, redoButton, undoButton, saveButton, filterField);
    }

    @Override
    public void addEventHandlers() {
        undoButton.setOnAction(event -> mountainlist.undo());
        redoButton.setOnAction(event -> mountainlist.redo());
        addButton.setOnAction(event -> mountainlist.addNewMountain());
        deleteButton.setOnAction(event -> mountainlist.removeMountain());
        saveButton.setOnAction(event -> mountainlist.save());
    }

    @Override
    public void addBindings() {
        undoButton.disableProperty().bind(mountainlist.undoDisabledProperty());
        redoButton.disableProperty().bind(mountainlist.redoDisabledProperty());
    }


    public TextField getFilterField() {
        return filterField;
    }
}
