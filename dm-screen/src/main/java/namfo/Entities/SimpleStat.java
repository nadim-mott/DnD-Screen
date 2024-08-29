package namfo.Entities;

import java.text.ParseException;
import java.util.Dictionary;
import java.util.Hashtable;

public class SimpleStat {
    private int amount;
    private int max;
    private String name;
    private Boolean locked;
    private Creature creature;
    private Dictionary<String,String> event_expressions;
    
    public SimpleStat(String name, Creature creature, boolean locked){
        this.name = name;
        this.amount = 0;
        this.max = 0;
        this.creature = creature;
        this.locked = locked;
        this.event_expressions = new Hashtable<String,String>();
    }

    public void modify_event_expression(String event, String expression) throws OutOfMemoryError{
        this.event_expressions.put(event, expression);
    }


    public void execute(String event){
        String event_expression = event_expressions.get(event);
        if (event_expression == null || event_expression.equals("")){
            return;
        }
        try {
            this.amount = Evaluator.parse_expression(event_expression, this.creature);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

    // ---- Getter and Setters: ----
    public int get_stat_amount(){
        return this.amount;
    }

    public void set_stat_amount(int new_amount){
        this.amount = new_amount;
    }

    public int get_stat_max(){
        return this.max;
    }

    public void set_stat_max(int new_max){
        this.max = new_max;
    }

    public String get_name(){
        return this.name;
    }

    public void set_name(String new_name){
        this.name = new_name;
    }

    public Boolean get_locked_status(){
        return this.locked;
    }

    private void set_locked_status(Boolean new_locked){
        this.locked = new_locked;
    }

    public Dictionary<String,String> get_event_expressions(){
        return event_expressions;
    } 

    



}
