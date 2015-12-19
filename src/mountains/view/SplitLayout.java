package mountains.view;

import javafx.scene.control.SplitPane;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class SplitLayout extends SplitPane {

    public SplitLayout(Mountain model) {
        initializeControls();
        layoutControls();  }

    private void initializeControls() {


    }
    private void layoutControls() {
        setDividerPosition(1,0);
    }
}

