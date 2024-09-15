package namfo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import namfo.Entities.SimpleStat;
import namfo.use_case.LoadCreatureUseCase.LoadCreatureInputBoundary;
import namfo.use_case.LoadCreatureUseCase.LoadCreatureOutputBoundary;
import namfo.use_case.LoadCreatureUseCase.LoadCreatureOutputData;

public class EditView implements LoadCreatureOutputBoundary{
    @FXML
    private CheckBox auto_roll_checkbox;

    private LoadCreatureInputBoundary LoadCreatureInteractor;

    @FXML
    private TextField auto_roll_modifier;

    @FXML
    private ColorPicker border_color_picker;

    @FXML
    private TextField name_field;

    @FXML
    private ImageView characterImage;

    @FXML
    private ImageView characterStatblock;

    @FXML
    private Button plus_button;

    @FXML
    private Button save_button;

    @FXML
    private VBox vertical_box;

    @FXML
    private HBox stat_labels;

    @FXML
    private Button plus_event;

    @FXML
    private Button minus_event;

    private final Double EVENT_LABEL_WIDTH = 150.0;


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


    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void select_image(ActionEvent event) {

    }


    @Override
    public void loadCreaturePrepareSuccessView(LoadCreatureOutputData data) {
        name_field.setText(data.getName());
        border_color_picker.setValue(data.getBorderColor());
        auto_roll_checkbox.setSelected(data.getAutoRoll());
        auto_roll_modifier.setText(data.getAutoRollExpression());
        characterImage.setImage(data.getImage());
        characterStatblock.setImage(data.getStatBlock());
        // TODO finish implementing.
        // handle events:
        HBox events = stat_labels;
        for (SimpleStat stat : data.getSimpleStat()){
            HBox simstat_row = new HBox();
            Label stat_name_label = new Label(stat.get_name());
            stat_name_label.setMaxWidth(EVENT_LABEL_WIDTH);
            stat_name_label.setMinWidth(EVENT_LABEL_WIDTH);
            simstat_row.getChildren().add(stat_name_label);


        }
        for (String event_string : data.getEvents()){
            Label event_name_label = new Label(event_string);
            event_name_label.setMinWidth(EVENT_LABEL_WIDTH);
            event_name_label.setMaxWidth(EVENT_LABEL_WIDTH);

            events.getChildren().add(event_name_label);
        }
        
        events.getChildren();

        
    }

    @Override
    public void loadCreaturePrepareFailView(LoadCreatureOutputData data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
