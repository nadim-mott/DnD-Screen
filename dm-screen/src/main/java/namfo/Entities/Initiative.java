package namfo.Entities;

import java.util.Iterator;

public class Initiative implements Iterable<Creature>{
    private Node head_node;
    private Node max_node;
    private Node tail_node;

    public Initiative(){
        head_node = null;
        max_node = null;
        tail_node = null;
    }

    public void next_turn(){
        this.head_node.get_creature().end_of_turn();
        this.tail_node = tail_node.next;
        this.head_node = head_node.next;
        this.head_node.get_creature().start_of_turn();
    }

    public void start_combat(){
        this.head_node = this.max_node;
        this.tail_node = this.max_node.prev;
        for (Creature creature : this){
            creature.start_combat();
        }
    }

    public void insert(float priority, Creature creature){
        Node new_node = new Node(priority, creature);
        if (this.head_node == null){
            this.head_node = new_node;
            this.tail_node = new_node;
            this.max_node = new_node;
            new_node.prev = null;
            new_node.next = null;
            return;
        }
        Node curr = this.max_node;
        if (priority > this.max_node.get_priority()){
            this.max_node.insert_before(new_node);
            this.max_node = new_node;
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
        for (Creature creature : this){
            returnee += creature.get_initiative() + ": " + creature.toString() + ",";
        }
        return returnee.replaceAll(",$", "]");
    }

    private void remove_Node(Node node){
        if (node.next == node) {
            this.tail_node = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            if (node == this.tail_node){
                this.tail_node = node.prev;
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


    @Override
    public Iterator<Creature> iterator() {
        return new CreatureIterator(this);
    }

    private class CreatureIterator implements Iterator<Creature>{
        private Node curr;
        private Initiative initiative;
        public CreatureIterator(Initiative initiative){
            this.initiative = initiative;
            this.curr = initiative.head_node;
        }

        @Override
        public boolean hasNext() {
            return this.curr == initiative.tail_node;
        }

        @Override
        public Creature next() {
            Creature returnee = this.curr.get_creature();
            this.curr = this.curr.next;
            return returnee;
        }
        
    }


    private class Node {
        private float priority;
        private Creature creature;
        public Node next;
        public Node prev;

        public Node(float priority, Creature creature){
            this.priority = priority;
            this.creature = creature;
            this.next = null;
            this.prev = next;
            creature.set_initiative(this.get_initiative());
        }

        public Creature get_creature(){
            return this.creature;
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
