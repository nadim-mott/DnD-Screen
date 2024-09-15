package namfo.Controllers;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import namfo.Entities.Creature;
import namfo.Entities.Evaluator;
import namfo.Entities.Initiative;
import namfo.data_access.BasicCreatureManager;
import namfo.data_access.CreatureManagerDataAccessInterface;

public class InitiativeTrackerPageController {

    private final Initiative initiative = new Initiative();

    private int creature_count = 0;

    @FXML
    private ChoiceBox<String> creature_choice_box;

    @FXML
    private TextField initiative_exp;

    @FXML
    private Button NextTurnButton;

    @FXML
    private TitledPane initiativeAccordion;

    @FXML
    private Button insertButton;

    @FXML
    private Accordion playerAccordion;

    @FXML
    private Label turnLabel;

    @FXML
    private Label insert_creature_error;

    private CreatureManagerDataAccessInterface dataAccessor;
    
    public InitiativeTrackerPageController(){
        this.dataAccessor = new BasicCreatureManager();
    }
    
    public void initialize(){
        insert_creature_error.setTextFill(Color.RED);
        insert_creature_error.setText("");
        fetchCreatures();
    }

    public void fetchCreatures(){
        List<String> names = dataAccessor.loadNames();
        for (String name : names){
            creature_choice_box.getItems().add(name);
        }
    }

    public 


    @FXML
    void insertCreature(ActionEvent event) {
        int selectedIndex = creature_choice_box.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0){
            insert_creature_error.setText("No creature selected");
            return;
        } else {
            Creature creature = dataAccessor.loadCreatureByIndex(selectedIndex);
            try {
                initiative.insert(getCreatureInitiative(creature, initiative_exp.getText()), creature);
                System.out.println(initiative.toString());
            } catch (ParseException e) {
                insert_creature_error.setText("Invalid Expression");
                e.printStackTrace();
                return;
            }
        }
        
        insert_creature_error.setText("");
        creature_count ++;
        
    }

    private float getCreatureInitiative(Creature creature, String expression) throws ParseException{
        Pattern add_modifier_pattern = Pattern.compile("[+-](.*)");
        Matcher add_modifier_expression_matcher = add_modifier_pattern.matcher(expression);
        if (add_modifier_expression_matcher.matches()) {
            Matcher add_modifer_autoroll = add_modifier_pattern.matcher(creature.getAutoRollExpression());
            if (add_modifer_autoroll.matches()){
                return (float) Evaluator.parse_expression(("1d20"+creature.getAutoRollExpression()+expression), creature);
            } else {
                return (float) Evaluator.parse_expression((creature.getAutoRollExpression()+expression), creature);
            }
        } else if (expression.equals("")) {
            if (creature.getAutoRollExpression().equals("")){
                return (float) Evaluator.parse_expression("1d20");
            }
            return (float) Evaluator.parse_expression(creature.getAutoRollExpression());
        } else {
            return (float) Evaluator.parse_expression(expression, creature);
        }
    }

    

    private TitledPane creatureTitledPane(Creature creature){
        return new TitledPane(creature.getName(), new Button("B1"));
    }

    @FXML
    void nextTurn(ActionEvent event) {

    }
    
    public void update_initiative(){

    }

}
