package namfo.use_case.LoadCreatureUseCase;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import namfo.Entities.SimpleStat;

public class LoadCreatureOutputData {
    private final String name;
    private final Color border_color;
    private final Boolean auto_roll;
    private final String auto_roll_expression;
    private final Image image;
    private final Image statblock;
    private final List<String> events;
    private final List<SimpleStat> simplestats;

    public LoadCreatureOutputData(String name, Color border_color, Boolean auto_roll, String auto_roll_expression, Image image, Image statblock, List<String> events, List<SimpleStat> simplestats) {
        this.name = name;
        this.border_color = border_color;
        this.auto_roll = auto_roll;
        this.auto_roll_expression = auto_roll_expression;
        this.image = image;
        this.statblock = statblock;
        this.events = events;
        this.simplestats = simplestats;
    }

    // ---- Getters and Setters: ----
    public List<String> getEvents(){
        return this.events;
    }
    public String getName(){
        return this.name;
    }
    public Color getBorderColor(){
        return this.border_color;
    }
    public Boolean getAutoRoll(){
        return this.auto_roll;
    }
    public String getAutoRollExpression(){
        return this.auto_roll_expression;
    }
    public Image getImage(){
        return this.image;
    }

    public Image getStatBlock(){
        return this.statblock;
    }

    public List<SimpleStat> getSimpleStat(){
        return this.simplestats;
    }
    
}
