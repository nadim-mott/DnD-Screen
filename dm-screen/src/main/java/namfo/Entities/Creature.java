package namfo.Entities;

public class Creature implements InitiativeEventInterface{
    private String name;
    private int initiative;
    public Creature(String name){
        this.name = name;
        
    }

    public String toString(){
        return name;
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
