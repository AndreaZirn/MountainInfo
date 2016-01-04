package mountains.view;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

    GridPane searchPane;
    Label searchLabel;
    private TextField searchField;

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
        searchPane = new GridPane();
        searchLabel = new Label();
        searchField = new TextField();
        mountainTable.setItems(mountainlist.sortedData);

        // SearchHandling
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            mountainlist.filteredData.setPredicate(mountain -> {
                // If filter text is empty, display all mountains.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare name of every mountain with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (mountain.getName() != null && mountain.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches name.
                }
                return false; // Does not match.
            });
        });
    }

    private TableView<Mountain> initializeMountainTabelle() {
        TableView<Mountain> tableView = new TableView<>(mountainlist.getMountains());

        idColumn = new TableColumn<>();
        nameColumn = new TableColumn<>();
        hoeheColumn = new TableColumn<>();

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

        nameColumn.setMinWidth(120);
        hoeheColumn.setMinWidth(35);
        idColumn.setMinWidth(35);
        idColumn.setPrefWidth(35);
        idColumn.setMaxWidth(40);

        this.setMaxWidth(300);
        this.setMinWidth(65);

        tableView.getColumns().addAll(idColumn, nameColumn, hoeheColumn);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.getSelectionModel().select(mountainlist.getMountain(1));

        setPadding(new Insets(10, 0, 10, 10));

        return tableView;
    }

    @Override
    public void layoutControls() {
        setVgrow(mountainTable, Priority.ALWAYS);
        getChildren().addAll(mountainTable, searchPane);
        searchPane.setPadding(new Insets(10, 0, 0, 0));
        searchPane.add(searchLabel, 0, 0);
        searchPane.add(searchField, 2, 0);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(30);
        ColumnConstraints c2 = new ColumnConstraints(1);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(69);
        searchPane.getColumnConstraints().addAll(c1, c2, c3);
    }

    @Override
    public void addEventHandlers() {
        mountainChangeListener = (observable, oldMountain, newMountain) -> {
            if (newMountain != null) {
                mountainlist.setSelectedMountainId(newMountain.getId());
            }
        };
        mountainTable.getSelectionModel().selectedItemProperty().addListener(mountainChangeListener);
    }

    @Override
    public void addValueChangedListeners() {
        mountainlist.selectedMountainIdProperty().addListener((observable, oldValue, newValue) -> {
            mountainTable.getSelectionModel().selectedItemProperty().removeListener(mountainChangeListener);

            if ((int) newValue == -1) {
                mountainTable.getSelectionModel().clearSelection();
            } else {
                mountainTable.getSelectionModel().select(mountainlist.getMountain((int) newValue));
            }
            mountainTable.getSelectionModel().selectedItemProperty().addListener(mountainChangeListener);
        });
    }

    @Override
    public void addBindings() {
        idColumn.textProperty().bind(languageModel.idColumnTextProperty());
        nameColumn.textProperty().bind(languageModel.nameColumnTextProperty());
        hoeheColumn.textProperty().bind(languageModel.hoeheColumnTextProperty());
        searchLabel.textProperty().bind(languageModel.searchLabelProperty());
        mountainlist.sortedData.comparatorProperty().bind(mountainTable.comparatorProperty());
    }

    //setter
    public Label getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(Label searchLabel) {
        this.searchLabel = searchLabel;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public void setSearchField(TextField searchField) {
        this.searchField = searchField;
    }
}
