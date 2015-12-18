package mountains.view;

import javafx.scene.layout.VBox;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class Tableview extends VBox {

    /*private TableView<Mountain> mountainTable;
    private TableColumn<Mountain, Integer> idColumn;
    private TableColumn<Mountain, String> nameColumn;
    private TableColumn<Mountain, Double> hoeheColumn;

    // Reference to the mountain list model
    private MountainListModel mountainListModel;
    private MountainStarter mountainStarter;
*/

    public Tableview(Mountain model) {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        /* Initialize the mountain table with the three columns.
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        hoeheColumn.setCellValueFactory(cellData -> cellData.getValue().hoeheProperty().asObject());
*/
    }

    private void layoutControls() {

    }
}
