/**
 * Desc: Generic Linked List implementation.
 */
public class LinkedList<E> {
    private Node<E> head;
    private int numItems;   // number of Node objects currently in the Linked List

    public LinkedList() {
        this.head = null;
        numItems = 0;
    }

    // ----------------------- Accessor methods ------------------------
    // YOUR CODE HERE
    public Node<E> getHead(){ return this.head; }
    public void setHead(Node<E> newNode){ this.head = newNode;}
    public int getNumItems(){
        return this.numItems;
    }
    public void setNumItems(int numItems){ this.numItems = numItems; }
    public boolean isEmpty() { return this.numItems == 0; }

    /**
     * Add an item to the head of the linked list
     * @param e item to add
     */
    public void addToHead(E e) {
        // YOUR CODE HERE
        //Assigning head to new node in LinkedList
        Node<E> newNode = new Node<>(e, this.head);
        this.head = newNode;
        this.numItems++;
    }
    
    /**
     * Remove item from the head of the linked list
     * @return item removed from the head of the linked list
     */
    public E removeFromHead() {
        // YOUR CODE HERE
        //Checking for empty LinkedList
        if(isEmpty()){
            return null;
        //Assigning head to second node in LinkedList
        }else{
            Node<E> tempNode = this.head;
            this.head = this.head.getNext();
            this.numItems--;

            return tempNode.getData();
        }
    }

    /**
     * Remove item from the tail of the linked list
     * @return item removed from the tail of the linked list
     */
    public E removeFromTail() {
        //Checking for empty LinkedList
        if(isEmpty()) {
            return null;
        //Checking for LinkedList with only 1 node
        }else if(this.head.getNext() == null){
            return removeFromHead();
        //Traverse LinkedList and remove last node
        }else{
            Node<E> slowNode = this.head;
            Node<E> fastNode = this.head.getNext();

            while(fastNode.getNext() != null){
                slowNode = slowNode.getNext();
                fastNode = fastNode.getNext();
            }
            slowNode.setNext(null);
            this.numItems--;
            return fastNode.getData();
        }
    }
}
