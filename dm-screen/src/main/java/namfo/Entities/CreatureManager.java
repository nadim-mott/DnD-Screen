package namfo.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatureManager {
    private List<Creature> creatures;
    private Set<Integer> saved_creatures;

    public CreatureManager() {
        this.creatures = new ArrayList<Creature>();
        this.saved_creatures = new HashSet<>();
    }

    
}
