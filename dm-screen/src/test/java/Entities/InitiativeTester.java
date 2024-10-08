package Entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import namfo.Entities.Creature;
import namfo.Entities.Initiative;
import namfo.Entities.InitiativeEventInterface;

public class InitiativeTester {
    public Initiative initialize_initiative(InitiativeEventInterface creature1, InitiativeEventInterface creature2, InitiativeEventInterface creature3){
        Initiative initiative = new Initiative();
        initiative.insert(1.12f, creature3);
        initiative.insert(2.1f, creature2);
        initiative.insert(3.1f, creature1);
        initiative.start_combat();
        return initiative;
    }

    @Test
    public void test_indexes_match(){
        Creature creature1 = new Creature("First creature");
        Creature creature2 = new Creature("Second creature");
        Creature creature3 = new Creature("Third creature");
        Initiative initiative = initialize_initiative(creature1, creature2, creature3);
        assertEquals(initiative.get_creature_at_index(0), creature1);
        assertEquals(initiative.get_creature_at_index(1), creature2);
        assertEquals(initiative.get_creature_at_index(2), creature3);
    }

    @Test
    public void test_toString(){
        Creature creature1 = new Creature("First creature");
        Creature creature2 = new Creature("Second creature");
        Creature creature3 = new Creature("Third creature");
        Initiative initiative = initialize_initiative(creature1, creature2, creature3);
        assertEquals("[3: First creature,2: Second creature,1: Third creature]", initiative.toString());
        initiative.next_turn();
        assertEquals("[2: Second creature,1: Third creature,3: First creature]", initiative.toString());
        Creature creature4 = new Creature("Fourth creature");
        initiative.insert(18.0f, creature4);
        assertEquals("[2: Second creature,1: Third creature,18: Fourth creature,3: First creature]", initiative.toString());
        initiative.start_combat();
        assertEquals("[18: Fourth creature,3: First creature,2: Second creature,1: Third creature]", initiative.toString());
    }



    @Test
    public void test_remove_first(){
        Creature creature1 = new Creature("First creature");
        Creature creature2 = new Creature("Second creature");
        Creature creature3 = new Creature("Third creature");
        Initiative initiative = initialize_initiative(creature1, creature2, creature3);
        initiative.remove_by_index(0);
        assertEquals("[2: Second creature,1: Third creature]", initiative.toString());
    }

    @Test
    public void test_remove_middle(){
        Creature creature1 = new Creature("First creature");
        Creature creature2 = new Creature("Second creature");
        Creature creature3 = new Creature("Third creature");
        Initiative initiative = initialize_initiative(creature1, creature2, creature3);
        initiative.remove_by_index(1);
        assertEquals("[3: First creature,1: Third creature]", initiative.toString());
    }

    @Test
    public void test_remove_last(){
        Creature creature1 = new Creature("First creature");
        Creature creature2 = new Creature("Second creature");
        Creature creature3 = new Creature("Third creature");
        Initiative initiative = initialize_initiative(creature1, creature2, creature3);
        initiative.remove_by_index(2);
        assertEquals("[3: First creature,2: Second creature]", initiative.toString());
    }

    @Test
    public void test_next_turn(){
        
    }


    private class mockCreature implements InitiativeEventInterface{

        @Override
        public void set_initiative(int _initiative) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'set_initiative'");
        }

        @Override
        public int get_initiative() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'get_initiative'");
        }

        @Override
        public void start_combat() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'start_combat'");
        }

        @Override
        public void start_of_turn() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'start_of_turn'");
        }

        @Override
        public void end_of_turn() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'end_of_turn'");
        }

    }


}
