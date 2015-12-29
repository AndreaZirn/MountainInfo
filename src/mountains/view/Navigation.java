package mountains.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import mountains.model.LanguageSwitcher;
import mountains.model.MountainListModel;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class Navigation extends HBox implements ViewMixin<MountainListModel>{

    private final MountainListModel mountainlist;

    private final LanguageSwitcher languageModel;

    private Button addButton;
    private Button deleteButton;
    private Button redoButton;
    private Button undoButton;
    private Button saveButton;

    private Button englishButton;
    private Button germanButton;

    HBox hbox1 = new HBox();

    public Navigation(MountainListModel mountainlist, LanguageSwitcher languageModel) {
        this.mountainlist = mountainlist;
        this.languageModel = languageModel;
        getStyleClass().add("buttonbar");
        init();
    }

    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }
    @Override
    public void initializeControls() {
        englishButton = new Button();
        germanButton = new Button();
        addButton = new Button();
        deleteButton = new Button();
        redoButton = new Button();
        undoButton = new Button();
        saveButton = new Button();

        hbox1.setAlignment(Pos.CENTER_RIGHT);
        hbox1.getChildren().addAll(englishButton, germanButton);

    }

    @Override
    public void layoutControls() {
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10));
        setSpacing(5);
        getChildren().addAll(addButton, deleteButton, redoButton, undoButton, saveButton, hbox1);
        setHgrow(hbox1, Priority.ALWAYS);
    }

    @Override
    public void addEventHandlers() {
        undoButton.setOnAction(event -> mountainlist.undo());
        redoButton.setOnAction(event -> mountainlist.redo());
        addButton.setOnAction(event -> mountainlist.addNewMountain());
        deleteButton.setOnAction(event -> mountainlist.removeMountain());
        saveButton.setOnAction(event -> mountainlist.save());
        germanButton.setOnAction(event -> languageModel.setLanguage(LanguageSwitcher.Lang.DE));
        englishButton.setOnAction(event -> languageModel.setLanguage(LanguageSwitcher.Lang.EN));
    }

    @Override
    public void addBindings() {
        undoButton.disableProperty().bind(mountainlist.undoDisabledProperty());
        redoButton.disableProperty().bind(mountainlist.redoDisabledProperty());
        germanButton.textProperty().bind(languageModel.germanButtonTextProperty());
        englishButton.textProperty().bind(languageModel.englishButtonTextProperty());
        saveButton.textProperty().bind(languageModel.saveButtonTextProperty());
        addButton.textProperty().bind(languageModel.addButtonTextProperty());
        deleteButton.textProperty().bind(languageModel.deleteButtonTextProperty());
        undoButton.textProperty().bind(languageModel.undoButtonTextProperty());
        redoButton.textProperty().bind(languageModel.redoButtonTextProperty());

    }

}
