package namfo.data_access;

import java.util.ArrayList;
import java.util.List;

import namfo.Entities.Creature;

public class BasicCreatureManager implements CreatureManagerDataAccessInterface {

    private List<Creature> creatures;

    public BasicCreatureManager(){
        this.creatures = new ArrayList<Creature>();
        Creature creature1 = new Creature("Mumbo Grumbo");
        Creature creature2 = new Creature("Grimpy Wimpy");
        Creature creature3 = new Creature("Lorza");
        Creature creature4 = new Creature("Strahd");
        creatures.add(creature1);
        creatures.add(creature2);
        creatures.add(creature3);
        creatures.add(creature4);
        
    }

    @Override
    public List<String> loadNames() {
        List<String> returnee = new ArrayList<String>();
        for (Creature creature : creatures){
            returnee.add(creature.getName());
        }
        return returnee;
    }

    @Override
    public Creature loadCreatureByIndex(int index) throws IndexOutOfBoundsException{
        // TODO Auto-generated method stub
        if (index == 0){
            return new Creature("Mumbo Grumbo");
        }
        if (index == 1){
            Creature creature = new Creature("Grimpy Wimpy");
            creature.setAutoRollExpression("4");
            return creature;
        }
        if (index == 2){
            Creature creature = new Creature("Lorza");
            creature.setAutoRollExpression("+5");
            return creature;
        }
        if (index == 3){
            Creature creature = new Creature("Strahd");
            creature.setAutoRollExpression("10");
            return creature;
        }
        throw new UnsupportedOperationException("Unimplemented method 'loadCreatureByIndex'");
    }

    @Override
    public void saveCreature(Creature creature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCreature'");
    }

    @Override
    public void removeCreature(int index) throws IndexOutOfBoundsException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeCreature'");
    }

}
