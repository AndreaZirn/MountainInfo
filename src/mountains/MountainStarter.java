package mountains;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mountains.model.Mountain;
import mountains.view.MountainUI;


public class MountainStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Mountain model = new Mountain();
        Parent rootPanel = new MountainUI(model);
        Scene scene = new Scene(rootPanel);

        /*CSS
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
         */

        primaryStage.titleProperty().bind(model.windowTitleProperty());
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