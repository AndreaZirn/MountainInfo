package mountains.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class Navigation extends HBox{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    public Navigation(Mountain model) {
        initializeControls();
        layoutControls();  }

    private void initializeControls() {
        button1 = new Button("add");
        button2 = new Button("delete");
        button3 = new Button("redo");
        button4 = new Button("undo");
        button5 = new Button("save");
    }
    private void layoutControls() {
        setPadding(new Insets(10));
        setSpacing(5);
        getChildren().addAll(button1, button2, button3, button4, button5);
    }
}
