package mountains.view;

import javafx.scene.layout.BorderPane;
import mountains.model.Mountain;

/**
 * Created by andreazirn on 18/12/15.
 */
public class MountainUI extends BorderPane implements ViewMixin<Mountain> {

    //TODO: Borderpane: oben: Navigation, center: SplitPane
    //Deklaration aller Controls
    private final Mountain model;

    private SplitLayout splitLayout;
    private Navigation navigation;
    private DataView dataview;
    private Tableview tableview;


    public MountainUI(Mountain model) {
        this.model = model;
        init();
    }

    @Override
    public Mountain getMountain() {
        return model;
    }

    @Override
    //Initialisierung aller Controls
    public void initializeControls() {
        splitLayout = new SplitLayout(model);
        navigation = new Navigation(model);
        dataview = new DataView(model);
        tableview = new Tableview(model);
    }

    //Anordenen aller Controler
    public void layoutControls() {
        setTop(navigation);
        setCenter(splitLayout);
        splitLayout.getItems().addAll(tableview, dataview);
    }
}

