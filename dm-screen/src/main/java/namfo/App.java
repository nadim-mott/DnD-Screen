package namfo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import namfo.Entities.Evaluator;

/**
 * JavaFX App
 */
public class App extends Application {
    public String ASSET_PATH = "file:dm-screen/src/Assets/";
    public String IMAGES_PATH = ASSET_PATH + "/Images/";


    public static void main(String[] args) {
        try {
            System.out.println(Integer.toString(Evaluator.parse_expression("")));
            System.out.println(Integer.toString(Evaluator.parse_expression("12")));
            System.out.println(Integer.toString(Evaluator.parse_expression("12+(12)2+1")));
            System.out.println(Integer.toString(Evaluator.parse_expression("1(-3*4)/2d6")));
            System.out.println(Integer.toString(Evaluator.parse_expression("12(3-4+2)2d6")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not parse string ...");
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = loadFXML("Main");
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}