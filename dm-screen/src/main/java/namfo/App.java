package namfo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import namfo.Controllers.ViewManager;

/**
 * JavaFX App
 */
public class App extends Application {
    public String ASSET_PATH = "file:dm-screen/src/Assets/";
    public String IMAGES_PATH = ASSET_PATH + "/Images/";
    public static ViewManager viewManager;


    public static void main(String[] args) {
        viewManager = new ViewManager();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        viewManager.set_scene("Edit", primaryStage);
        primaryStage.show();
        
        
    }

}