package mountains.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class DataView extends GridPane {


    Label nameLabel;
    Label hoeheLabel;
    Label dominanzLabel;
    Label kmBisLabel;
    Label mBisLabel;
    Label schartenhoeheLabel;
    Label typLabel;
    Label regionLabel;
    Label kantonLabel;
    Label gebietLabel;
    Label bildunterschriftLabel;

    private TextField nameField;
    private TextField hoeheField;
    private TextField dominanzField;
    private TextField kmBisField;
    private TextField mBisField;
    private TextField schartenhoeheField;
    private TextField typField;
    private TextField regionField;
    private TextField kantonField;
    private TextField gebietField;
    private TextField bildunterschriftField;

    private Mountain mountain;


    public DataView(Mountain model) {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {

        nameLabel = createLabel("Name:");
        hoeheLabel= createLabel("Höhe:");
        dominanzLabel = createLabel("Dominanz:");
        kmBisLabel = createLabel("Km bis:");
        mBisLabel = createLabel("M bis:");
        schartenhoeheLabel = createLabel("Schartenhöhe:");
        typLabel = createLabel("Typ:");
        regionLabel = createLabel("Region:");
        kantonLabel = createLabel("Kanton:");
        gebietLabel = createLabel("Gebiet:");
        bildunterschriftLabel = createLabel("Bildunterschrift:");

        nameField = new TextField();
        hoeheField = new TextField();
        dominanzField = new TextField();
        kmBisField = new TextField();
        mBisField = new TextField();
        schartenhoeheField = new TextField();
        typField = new TextField();
        regionField = new TextField();
        kantonField = new TextField();
        gebietField = new TextField();
        bildunterschriftField = new TextField();


    }


    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(20);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(30);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(20);
        ColumnConstraints c4 = new ColumnConstraints();
        c4.setPercentWidth(30);
        getColumnConstraints().addAll(c1, c2, c3, c4);

        /*RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS); */
        RowConstraints r1 = new RowConstraints(50);
        RowConstraints r2 = new RowConstraints(50);
        RowConstraints r3 = new RowConstraints(50);
        RowConstraints r4 = new RowConstraints(50);
        RowConstraints r5 = new RowConstraints(50);
        RowConstraints r6 = new RowConstraints(50);
        getRowConstraints().addAll(r1, r2, r3, r4, r5, r6);


        add(nameLabel, 0, 0, 2, 2);
        add(hoeheLabel, 2, 0, 2, 2);
        add(dominanzLabel, 0, 1, 2, 2);
        add(kmBisLabel, 2, 1, 2, 2);
        add(mBisLabel, 0, 2, 2, 2);
        add(schartenhoeheLabel, 2, 2, 2, 2);
        add(typLabel, 0, 3, 2, 2);
        add(regionLabel, 2, 3, 2, 2);
        add(kantonLabel, 0, 4, 2, 2);
        add(gebietLabel, 2, 4, 2, 2);
        add(bildunterschriftLabel, 0, 5, 2, 2);

        add(nameField, 1, 0, 1, 1);
        add(hoeheField, 3, 0, 1, 1);
        add(dominanzField, 1, 1, 1, 1);
        add(kmBisField, 3, 1, 1, 1);
        add(mBisField, 1, 2, 1, 1);
        add(schartenhoeheField, 3, 2, 1, 1);
        add(typField, 1, 3, 1, 1);
        add(regionField, 3, 3, 1, 1);
        add(kantonField, 1, 4, 1, 1);
        add(gebietField, 3, 4, 1, 1);
        add(bildunterschriftField, 1, 5, 1, 1);


// add(hoeheField, 0, 0, 1, 2); //colIndex, rowIndex, colSpan, rowSpan


    }

    private Label createLabel(String text){
        Label label = new Label(text);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMaxHeight(Double.MAX_VALUE);
        return label;
}
}
