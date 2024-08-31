package namfo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditView {
    @FXML
    private CheckBox auto_roll_checkbox;

    @FXML
    private TextField auto_roll_modifier;

    @FXML
    private ColorPicker border_color_picker;

    @FXML
    private TextField name_field;

    @FXML
    private Button plus_button;

    @FXML
    private Button save_button;

    @FXML
    private VBox vertical_box;

    @FXML
    void auto_roll_tick(ActionEvent event) {
        Boolean ticked = auto_roll_checkbox.isSelected();
        auto_roll_modifier.setDisable(!ticked);

    }

    @FXML
    void press_more(ActionEvent event) {
        HBox hbox = new HBox();
        int bottom = vertical_box.getChildren().size() - 2;
        vertical_box.getChildren().add(bottom, hbox);
        
        TextField name_field = new TextField();
        name_field.setPromptText("Variable name");
        hbox.getChildren().add(name_field);

        TextField value_field = new TextField();
        value_field.setPromptText("Value");
        hbox.getChildren().add(value_field);

        TextField max_field = new TextField();
        max_field.setPromptText("max");
        hbox.getChildren().add(max_field);



    }

    public void load_creature(){
        
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void select_image(ActionEvent event) {

    }

}
