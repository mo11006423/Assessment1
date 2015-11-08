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
    private Node<T> first; // "First" node
    private int size; // size of the list

    public UnsortedLinkedPriorityQueue() {
        head = null;
        previous = null;
        next = null;
        focus = null;
        size = 0;
        first = null;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (isEmpty()) {
            first = new Node<>(item, priority, null, null);
            head = first;
        } else if (size == 1) {
            first.setNext(new Node<>(item, priority, null, first));
        } else {
            setFocus(size);
            focus.setNext(new Node<>(item, priority, null, focus));
        }
        size++;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (size == 1) {
            return head.getItem();
        } else {
            focus = first;
            while (focus != null) {
                if (focus.getPriority() > head.getPriority()) {
                    head = focus;
                } else {
                    focus = focus.getNext();
                }
            }
        }
        return head.getItem();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (size == 1) {
            first = null;
        } else {
            head();
            if (head == first) {
                first = head.getNext();
                head.getNext().setPrevious(null);
            } else {
                if (head.getNext() != null && head.getPrevious() != null) {
                    head.getNext().setPrevious(head.getPrevious());
                    head.getPrevious().setNext(head.getNext());
                } else if (head.getNext() == null && head.getPrevious() != null) {
                    head.getPrevious().setNext(null);
                }
            }

        }

        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        setFocus(size);
        String output = "";
        int counter = size;
        while (focus != null) {
            counter--;
            if (size == 1) {
                output = focus.getItem().toString();
                break;
            } else if (counter == size) {
                output += focus.getItem().toString();
                break;
            } else {
                output += focus.getItem().toString() + ", ";
                focus = focus.getPrevious();
            }
        }
        return output;
    }

    private void setFocus(int index) {
        focus = first;
        for (int i = 0; i < index - 1; i++) {
            focus = focus.getNext();
        }
    }

}
