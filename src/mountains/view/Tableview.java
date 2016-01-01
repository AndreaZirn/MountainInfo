package mountains.view;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import mountains.model.LanguageSwitcher;
import mountains.model.Mountain;
import mountains.model.MountainListModel;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class Tableview extends VBox implements ViewMixin<MountainListModel> {
    // Reference to the mountain list model
    private final MountainListModel mountainlist;

    private final LanguageSwitcher languageModel;

    private TableView<Mountain> mountainTable;
    private ChangeListener<Mountain> mountainChangeListener;

    TableColumn<Mountain, Integer> idColumn;
    TableColumn<Mountain, String> nameColumn;
    TableColumn<Mountain, Double> hoeheColumn;


    public Tableview(MountainListModel mountainlist, LanguageSwitcher languageModel) {
        this.mountainlist = mountainlist;
        this.languageModel = languageModel;
        init();
    }


    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }
    @Override
    public void initializeControls() {
        mountainTable = initializeMountainTabelle();
    }

    private TableView<Mountain> initializeMountainTabelle(){
        TableView<Mountain> tableView = new TableView<>(mountainlist.getMountains());

        idColumn = new TableColumn<>();
        nameColumn = new TableColumn<>();
        hoeheColumn = new TableColumn<>();

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

        nameColumn.setMinWidth(120);
        hoeheColumn.setMinWidth(30);
        idColumn.setMinWidth(20);

        this.setMaxWidth(275);

        tableView.getColumns().addAll(idColumn, nameColumn, hoeheColumn);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.getSelectionModel().select(mountainlist.getMountain(1));

        setPadding(new Insets(10, 0, 10, 10));

        return tableView;
    }


    @Override
    public void layoutControls() {
        setVgrow(mountainTable, Priority.ALWAYS);
        getChildren().addAll(mountainTable);

    }
    @Override
    public void addEventHandlers() {
        mountainChangeListener = (observable, oldMountain, newMountain) -> mountainlist.setSelectedMountainId(newMountain.getId());
        mountainTable.getSelectionModel().selectedItemProperty().addListener(mountainChangeListener);
    }

    @Override
    public void addValueChangedListeners() {
        mountainlist.selectedMountainIdProperty().addListener((observable, oldValue, newValue) -> {
            mountainTable.getSelectionModel().selectedItemProperty().removeListener(mountainChangeListener);

            if((int)newValue == -1){
                mountainTable.getSelectionModel().clearSelection();
            }
            else {
                mountainTable.getSelectionModel().select(mountainlist.getMountain((int)newValue));
            }

            mountainTable.getSelectionModel().selectedItemProperty().addListener(mountainChangeListener);

        });
    }
    @Override
    public void addBindings() {
        idColumn.textProperty().bind(languageModel.idColumnTextProperty());
        nameColumn.textProperty().bind(languageModel.nameColumnTextProperty());
        hoeheColumn.textProperty().bind(languageModel.hoeheColumnTextProperty());

    }
}
