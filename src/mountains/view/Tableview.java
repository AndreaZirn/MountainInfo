package mountains.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import mountains.model.Mountain;
import mountains.model.MountainListModel;

/**
 * Created by andreazirn on 18/12/15.
 */
public class Tableview extends VBox {

    // Reference to the mountain list model
    private MountainListModel mountainListModel;

    private TableView<Mountain> mountainTable;


    public Tableview(Mountain model) {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }


    private void initializeControls() {
        mountainTable = initializeMountainTabelle();
    }

    private TableView<Mountain> initializeMountainTabelle(){
        TableView<Mountain> tableView = new TableView<>(mountainListModel.getMountain());

        TableColumn<Mountain, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Mountain, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Mountain, Double> hoeheColumn = new TableColumn<>("Höhe");

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

        tableView.getColumns().addAll(idColumn, nameColumn, hoeheColumn);

        return tableView;
    }



    private void layoutControls() {
        setVgrow(mountainTable, Priority.ALWAYS);
        getChildren().addAll(mountainTable);

    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    public void addBindings() {

    }
}
