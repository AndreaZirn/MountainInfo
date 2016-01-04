package mountains.view;

import javafx.scene.layout.BorderPane;
import mountains.model.LanguageSwitcher;
import mountains.model.MountainListModel;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

public class MountainUI extends BorderPane implements ViewMixin<MountainListModel> {
    // Reference to the mountain list model
    private final MountainListModel model;
    private final LanguageSwitcher languageModel;

    private SplitLayout splitLayout;
    private Navigation navigation;
    private DataView dataview;
    private Tableview tableview;

    public MountainUI(MountainListModel model, LanguageSwitcher languageModel) {
        this.model = model;
        this.languageModel = languageModel;
        init();
    }

    @Override
    public MountainListModel getPresentationModel() {
        return model;
    }

    @Override
    //initialization from every controler
    public void initializeControls() {
        splitLayout = new SplitLayout(model);
        navigation = new Navigation(model, languageModel);
        dataview = new DataView(model, languageModel);
        tableview = new Tableview(model, languageModel);
    }

    //arrange every controler
    public void layoutControls() {
        setTop(navigation);
        setCenter(splitLayout);
        splitLayout.getItems().addAll(tableview, dataview);
    }
}

