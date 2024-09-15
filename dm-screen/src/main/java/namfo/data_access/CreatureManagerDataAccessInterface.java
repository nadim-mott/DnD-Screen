package namfo.data_access;

import java.util.List;

import namfo.Entities.Creature;

public interface CreatureManagerDataAccessInterface {
    public List<String> loadNames();
    public Creature loadCreatureByIndex(int index) throws IndexOutOfBoundsException;
    public void saveCreature(Creature creature);
    public void removeCreature(int index) throws IndexOutOfBoundsException;

}
