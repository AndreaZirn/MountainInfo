package mountains.view;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.converter.NumberStringConverter;
import mountains.model.LanguageSwitcher;
import mountains.model.Mountain;
import mountains.model.MountainListModel;


/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class DataView extends GridPane implements ViewMixin<MountainListModel> {
    // Reference to the mountain list model
    private final MountainListModel mountainlist;

    private final LanguageSwitcher languageModel;

    HBox hboxImage;

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

    //ImageHandling
    private  Image image;
    private ImageView imageView;

    public DataView(MountainListModel mountainlist, LanguageSwitcher languageModel) {
        this.mountainlist = mountainlist;
        this.languageModel = languageModel;
        init();
    }

    @Override
    public MountainListModel getPresentationModel() {
        return mountainlist;
    }


    @Override
    public void initializeControls() {

        //setHgap(5);
        setVgap(20);
        setPadding(new Insets(10, 10, 10, 10)); //top, right, bottom, left

        hboxImage = new HBox();
        hboxImage.setAlignment(Pos.CENTER);

        nameLabel = new Label();
        hoeheLabel = new Label();
        dominanzLabel = new Label();
        kmBisLabel = new Label();
        mBisLabel = new Label();
        schartenhoeheLabel = new Label();
        typLabel = new Label();
        regionLabel = new Label();
        kantonLabel = new Label();
        gebietLabel = new Label();
        bildunterschriftLabel = new Label();

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

        //ImageHandling
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(320);
        imageView.setFitWidth(600);

    }

    @Override
    public void layoutControls() {
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(20);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(28);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPercentWidth(4);
        ColumnConstraints c4 = new ColumnConstraints();
        c4.setPercentWidth(20);
        ColumnConstraints c5 = new ColumnConstraints();
        c5.setPercentWidth(28);
        getColumnConstraints().addAll(c1, c2, c3, c4, c5);
        c1.setHgrow(Priority.ALWAYS);


        //RowConstraints rc = new RowConstraints();
        //
        RowConstraints r1 = new RowConstraints();
        r1.setPercentHeight(60);
        r1.setVgrow(Priority.ALWAYS);
        RowConstraints r2 = new RowConstraints(30);
        RowConstraints r3 = new RowConstraints(30);
        RowConstraints r4 = new RowConstraints(30);
        RowConstraints r5 = new RowConstraints(30);
        RowConstraints r6 = new RowConstraints(30);
        RowConstraints r7 = new RowConstraints(30);
        getRowConstraints().addAll(r1, r2, r3, r4, r5, r6, r7);

        //Add image into the first row in Gridpane
        hboxImage.getChildren().add(imageView);
        add(hboxImage, 0, 0, 5, 1);

        add(nameLabel, 0, 1);
        add(hoeheLabel, 3, 1);
        add(dominanzLabel, 0, 2);
        add(kmBisLabel, 3, 2);
        add(mBisLabel, 0, 3);
        add(schartenhoeheLabel, 3, 3);
        add(typLabel, 0, 4);
        add(regionLabel, 3, 4);
        add(kantonLabel, 0, 5);
        add(gebietLabel, 3, 5);
        add(bildunterschriftLabel, 0, 6);

        add(nameField, 1, 1);
        add(hoeheField, 4, 1);
        add(dominanzField, 1, 2);
        add(kmBisField, 4, 2);
        add(mBisField, 1, 3);
        add(schartenhoeheField, 4, 3);
        add(typField, 1, 4);
        add(regionField, 4, 4);
        add(kantonField, 1, 5);
        add(gebietField, 4, 5);
        add(bildunterschriftField, 1, 6, 3, 1); //colIndex, rowIndex, colSpan, rowSpan

    }


    @Override
    public void addBindings() {
        Mountain mountainProxy = mountainlist.getMountainProxy();

        nameLabel.textProperty().bind(languageModel.nameLabelProperty());
        hoeheLabel.textProperty().bind(languageModel.hoeheLabelProperty());
        dominanzLabel.textProperty().bind(languageModel.dominanzLabelProperty());
        kmBisLabel.textProperty().bind(languageModel.kmBisLabelProperty());
        mBisLabel.textProperty().bind(languageModel.mBisLabelProperty());
        schartenhoeheLabel.textProperty().bind(languageModel.schartenhoeheLabelProperty());
        typLabel.textProperty().bind(languageModel.typLabelProperty());
        regionLabel.textProperty().bind(languageModel.regionLabelProperty());
        kantonLabel.textProperty().bind(languageModel.kantonLabelProperty());
        gebietLabel.textProperty().bind(languageModel.gebietLabelProperty());
        bildunterschriftLabel.textProperty().bind(languageModel.bildunterschriftLabelProperty());


        //imageHandling
        imageView.imageProperty().bindBidirectional(mountainProxy.imagePropertyProperty());

        nameField.textProperty().bindBidirectional(mountainProxy.nameProperty());
        Bindings.bindBidirectional(hoeheField.textProperty(), mountainProxy.hoeheProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(dominanzField.textProperty(), mountainProxy.hoeheProperty(), new NumberStringConverter());
        kmBisField.textProperty().bindBidirectional(mountainProxy.kmBisProperty());
        mBisField.textProperty().bindBidirectional(mountainProxy.mBisProperty());
        Bindings.bindBidirectional(schartenhoeheField.textProperty(), mountainProxy.schartenhoeheProperty(), new NumberStringConverter());
        typField.textProperty().bindBidirectional(mountainProxy.typProperty());
        regionField.textProperty().bindBidirectional(mountainProxy.regionProperty());
        kantonField.textProperty().bindBidirectional(mountainProxy.kantonProperty());
        gebietField.textProperty().bindBidirectional(mountainProxy.gebietProperty());
        bildunterschriftField.textProperty().bindBidirectional(mountainProxy.bildunterschriftProperty());
        }


}
