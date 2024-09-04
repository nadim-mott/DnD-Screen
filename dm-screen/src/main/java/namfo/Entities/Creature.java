package namfo.Entities;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Creature implements InitiativeEventInterface{
    private String name;
    private int initiative;
    private Color color;
    private Boolean auto_roll;
    private String auto_roll_expression;
    private Image image;
    private List<String> events;
    private List<SimpleStat> statistics;
    
    public Creature(String name){
        this.name = name;
        this.statistics = new LinkedList<SimpleStat>();
    }

    public String toString(){
        return name;
    }

    public SimpleStat get_stat_by_name(String name) throws OutOfMemoryError{
        for (SimpleStat statistic : this.statistics){
            if (statistic.get_name().equals(name)){
                return statistic;
            }
        }
        throw new OutOfMemoryError("Could not find stat with name \"" + name + "\"");
    }

    public void start_of_turn(){

    }

    public void end_of_turn(){

    }

    public void start_combat(){

    }

    // ---- Getters and Setters: ----
    public int get_initiative() {
        return this.initiative;
    }

    public void set_initiative(int new_initiative){
        this.initiative = new_initiative;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String new_name){
        this.name = new_name;
    }

    public Color getBorderColor(){
        return this.color;
    }

    public void setBorderColor(Color new_color){
        this.color = new_color;
    }

    public Boolean getAutoRoll(){
        return this.auto_roll;
    }
    
    public void setAutoRoll(Boolean new_auto_roll){
        this.auto_roll = new_auto_roll;
    }

    public String getAutoRollExpression(){
        return this.auto_roll_expression;
    }

    public void setAutoRollExpression(String new_auto_roll_expression){
        this.auto_roll_expression = new_auto_roll_expression;
    }

    public Image getImage(){
        return this.image;
    }

    public void setImage(Image new_image){
        this.image = new_image;
    }

    public List<String> getEvents(){
        return this.events;
    }

    public List<SimpleStat> getSimpleStats(){
        return this.statistics;
    }
}
