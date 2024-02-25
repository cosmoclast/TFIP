/**
 * Desc: Node class to store the content items. Each node will store 1 content item.
 */
public class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E e, Node<E> n) {
        this.data = e;
        this.next = n;
    }

    // ----------------------- Accessor methods ------------------------
    // YOUR CODE HERE
    public Node<E> getNext(){ return this.next; }
    public void setNext(Node<E> nextNode){ this.next = nextNode; }
    public E getData(){ return this.data; }
    public void setData(E e){ this.data = e; }

    @Override
    public String toString() {
        return String.format("CONTENT:%s\n", this.data);
    }
}
