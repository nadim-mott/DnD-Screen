package namfo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import namfo.Entities.Creature;
import namfo.Entities.Evaluator;
import namfo.Entities.Initiative;

public class InitiativeTrackerPageController {

    private final Initiative initiative = new Initiative();

    private int creature_count = 0;

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
    void insertCreature(ActionEvent event) {
        initiative.insert((float) Evaluator.evaluate_nDm(1, 20), new Creature("creature" + Integer.toString(creature_count)));
        creature_count ++;
        TitledPane creature_pane = new TitledPane("T1", new Button("B1"));
        playerAccordion.getPanes().add(creature_pane);
    }

    @FXML
    void nextTurn(ActionEvent event) {

    }
    
    public void update_initiative(){

    }

}
