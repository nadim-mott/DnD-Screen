package namfo.Entities;

import java.util.Iterator;

public class Initiative implements Iterable<Character>{
    private Node topInitiative;
    private Node maxInitiative;
    private Node BottomInitiative;

    public void next_turn(){

    }
    public void insert(short initiative, Creature creature){

    }
    public void remove_by_creature(Creature creature){

    }
    public void remove_by_index(int index){

    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Character next() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            
        };
    }



    private class Node {
        public float priority;
        public Creature creature;
        public int index;
        public Node next;
        public Node prev;
        public int get_initiative(){
            return Math.round(priority);
        }
        
    }
}
