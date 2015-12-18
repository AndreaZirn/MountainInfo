package mountains.view;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class DataView extends GridPane {
    Label LabelId;
    Label Label2;
    Label Label3;


    public DataView(Mountain model) {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        LabelId = createLabel("Id:");
        Label2 = createLabel("second:");
        Label3 = createLabel("next:");
    }


    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc);

        add(LabelId, 0, 0); //colIndex, rowIndex
        add(Label2, 1, 0);
        add(Label3, 0, 0, 1, 2); //colIndex, rowIndex, colSpan, rowSpan  add(button3, 0, 1);
    }

    private Label createLabel(String text){
        Label label = new Label(text);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMaxHeight(Double.MAX_VALUE);
        return label;
}
}
