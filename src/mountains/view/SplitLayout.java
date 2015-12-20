package mountains.view;

import javafx.scene.control.SplitPane;
import mountains.model.MountainListModel;

/**
 * Created by andreazirn on 18/12/15.
 */
public class SplitLayout extends SplitPane implements ViewMixin<MountainListModel> {

    private final MountainListModel mountainlist;

    public SplitLayout(MountainListModel mountainlist) {
        this.mountainlist = mountainlist;
        initializeControls();
        layoutControls();  }

    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }
    @Override
    public void initializeControls() {
    }
    @Override
    public void layoutControls() {
        setDividerPosition(1,0);
    }
}

