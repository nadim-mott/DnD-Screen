package namfo.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import namfo.App;

public class ViewManager {
    public void set_scene(String fxml, Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("SceneBuilderFiles/" + fxml + ".fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);  
                  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
