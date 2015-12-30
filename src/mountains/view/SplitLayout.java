package mountains.view;

import javafx.scene.control.SplitPane;
import mountains.model.MountainListModel;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class SplitLayout extends SplitPane implements ViewMixin<MountainListModel> {

    private final MountainListModel mountainlist;

    public SplitLayout(MountainListModel mountainlist) {
        this.mountainlist = mountainlist;
        init();
    }


    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }
    @Override
    public void initializeControls() {
    }
    @Override
    public void layoutControls() {
<<<<<<< HEAD
        setDividerPositions(0.4, 0.6);
=======
        setDividerPositions(0.309, 0.6);
>>>>>>> origin/master
    }
}

