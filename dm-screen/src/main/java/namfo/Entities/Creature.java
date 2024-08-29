package namfo.Entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Creature implements InitiativeEventInterface{
    private String name;
    private int initiative;
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

    // ---- Getters and Setters: ----
    public void set_initiative(int initiative){
        this.initiative = initiative;
    }
    public int get_initiative() {
        return this.initiative;
    }

    public void start_of_turn(){

    }

    public void end_of_turn(){

    }

    public void start_combat(){

    }
    



}
