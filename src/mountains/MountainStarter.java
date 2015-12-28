package mountains;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mountains.model.LanguageSwitcher;
import mountains.model.MountainListModel;
import mountains.view.MountainUI;


public class MountainStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
            MountainListModel model = new MountainListModel();

            LanguageSwitcher languageModel = new LanguageSwitcher();

            Parent rootPanel = new MountainUI(model, languageModel);

            Scene scene = new Scene(rootPanel);


        /*String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);*/

        
            primaryStage.getIcons().add(new Image("wappen/wappen_gross/switzerland.png"));

            primaryStage.titleProperty().bind(languageModel.applicationTitleProperty());
            primaryStage.setScene(scene);

            primaryStage.setWidth(900);
            primaryStage.setHeight(750);
            primaryStage.centerOnScreen();

            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
}