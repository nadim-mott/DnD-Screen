package namfo.Entities;

import java.util.Dictionary;

public class SimpleStat {
    private int amount;
    private int max;
    private String name;
    private Boolean locked;
    private Dictionary<String,String> event_expressions;
    
    public SimpleStat(String name, boolean locked){

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
