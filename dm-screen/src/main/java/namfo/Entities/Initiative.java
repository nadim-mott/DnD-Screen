package namfo.Entities;

import java.util.Iterator;

public class Initiative implements Iterable<InitiativeEventInterface>{
    private Node head_node;
    private Node max_node;
    private int round;

    public Initiative(){
        /* This class describes an ordered set of creatures that are involved in a combat
         * encounter. Each creature is ordered based on their 'initiative value' as described in
         * the Dungeons and Dragons player handbook (2014) pg 189. The underlying data structure 
         * that stores the creature's turn order is a circular doubly linked list as described on
         * https://en.wikipedia.org/wiki/Doubly_linked_list
         */
        this.head_node = null;
        this.max_node = null;
        this.round = -1;
        
    }

    public void next_turn(){
        /* This method cycles through the initiative order, performing the end of turn stat modifications
         * to the creature whose turn it currently is before changing the turn to be the next creature and 
         * performing that creature's end of turn stat modifications.
         */
        if (this.round < 0){
            start_combat();
        } else if (this.head_node == this.max_node){
            this.round ++;
        }
        this.head_node.get_creature().end_of_turn();
        this.head_node = head_node.next;
        this.head_node.get_creature().start_of_turn();
    }

    public void start_combat(){
        this.head_node = this.max_node;
        for (InitiativeEventInterface ini : this){
            ini.start_combat();
        }
        this.round = 0;
    }

    public void insert(float priority, InitiativeEventInterface creature){
        Node new_node = new Node(priority, creature);
        if (this.head_node == null){
            this.head_node = new_node;
            this.max_node = new_node;
            new_node.prev = new_node;
            new_node.next = new_node;
            return;
        }
        Node curr = this.max_node;
        if (priority > this.max_node.get_priority()){
            this.max_node.insert_before(new_node);
            this.max_node = new_node;
            if (this.round < 0){
                this.head_node = new_node;
            }
            return;
        } 
        do { 
            if (priority > curr.get_priority()){
                curr.insert_before(new_node);
                return;
            }
            curr = curr.next;
        } while (curr != this.max_node);
        this.max_node.insert_before(new_node);
    }

    public void remove_by_index(int index) throws IndexOutOfBoundsException{
        Node node = this.get_node_at_index(index);
        remove_Node(node);
    }

    public String toString(){
        String returnee = "[";
        for (InitiativeEventInterface ini : this){
            returnee += ini.get_initiative() + ": " + ini.toString() + ",";
        }
        return returnee.replaceAll(",$", "]");
    }

    private void remove_Node(Node node){
        if (node.next == node) {
            this.head_node = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            if (node == this.head_node){
                this.head_node = node.next;
            }
        }
    }

    private Node get_node_at_index(int index) throws IndexOutOfBoundsException{
        int curr_index = 0;
        Node curr_node = this.head_node;
        if (curr_node == null){
            throw new IndexOutOfBoundsException();
        }
        while (curr_index < index){
            curr_index += 1;
            curr_node = curr_node.next;
        }
        return curr_node;
    }

    public InitiativeEventInterface get_creature_at_index(int index) throws IndexOutOfBoundsException{
        return get_node_at_index(index).get_creature();
    }


    @Override
    public Iterator<InitiativeEventInterface> iterator() {
        return new CreatureIterator(this);
    }

    private class CreatureIterator implements Iterator<InitiativeEventInterface>{
        private Node curr;
        private Initiative initiative;
        private boolean done;
        public CreatureIterator(Initiative initiative){
            this.initiative = initiative;
            this.curr = initiative.head_node;
            if (this.curr != null){
                this.done = true;
            } else {
                this.done = false;
            }
            
        }

        @Override
        public boolean hasNext() {
            return this.done;
        }

        @Override
        public InitiativeEventInterface next() {
            if (this.curr == initiative.head_node.prev){
                this.done = false;
            }
            InitiativeEventInterface returnee = this.curr.get_creature();
            this.curr = this.curr.next;
            return returnee;
        }
        
    }


    private class Node {
        private float priority;
        private final InitiativeEventInterface ini;
        public Node next;
        public Node prev;

        public Node(float priority, InitiativeEventInterface ini){
            this.priority = priority;
            this.ini = ini;
            this.next = null;
            this.prev = null;
            ini.set_initiative(this.get_initiative());
        }

        public InitiativeEventInterface get_creature(){
            return this.ini;
        }

        public float get_priority(){
            return this.priority;
        }

        public int get_initiative(){
            return Math.round(priority);
        }

        private void insert_after(Node new_node){
            new_node.next = this.next;
            new_node.prev = this;
            this.next.prev = new_node;
            this.next = new_node;
        }

        private void insert_before(Node new_node){
            this.prev.insert_after(new_node);
        }
    
        
    }
}
