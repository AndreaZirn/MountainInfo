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
public class Tableview extends VBox implements ViewMixin<MountainListModel> {
    // Reference to the mountain list model
    private final MountainListModel mountainlist;

    private TableView<Mountain> mountainTable;


    public Tableview(MountainListModel mountainlist) {
        this.mountainlist = mountainlist;
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
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
        TableView<Mountain> tableView = new TableView<>(mountainlist.getMountain());

        TableColumn<Mountain, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Mountain, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Mountain, Double> hoeheColumn = new TableColumn<>("Höhe");

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());

        tableView.getColumns().addAll(idColumn, nameColumn, hoeheColumn);

        return tableView;
    }


    @Override
    public void layoutControls() {
        setVgrow(mountainTable, Priority.ALWAYS);
        getChildren().addAll(mountainTable);

    }
    @Override
    public void addEventHandlers() {
    }
    @Override
    public void addValueChangedListeners() {
    }
    @Override
    public void addBindings() {

    }
}
