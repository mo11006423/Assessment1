package queuemanager;

/**
 *
 * @author Jamie Simpson
 * @param <T>
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    private Node<T> head; //Node at the top (highest priority)
    private Node<T> previous; //previous node
    private Node<T> focus; //current
    private Node<T> next; // Next node
    private int size; // size of the list

    public UnsortedLinkedPriorityQueue() {
        head = null;
        previous = null;
        next = null;
        focus = null;
        size = 0;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        //To be implemented
    }

    @Override
    public T head() throws QueueUnderflowException {
        //To be implemented
        return null;
    }

    @Override
    public void remove() throws QueueUnderflowException {
        //To be implemented

    }

    @Override
    public boolean isEmpty() {
        //To be implemented
        return false;
    }

}
