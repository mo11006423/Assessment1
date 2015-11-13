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

    /**
     * This method should not actually be able to throw an overflow exception as
     * it is dynamic.
     *
     * If it is empty a new first node is added and the head is assigned to that
     * value, if the size is 1 then the next value of first is set to the new
     * value and the new values previous pointer is set to first.
     *
     * If the size is not 1 then we set the focus node (our main pointer) to the
     * size and set its next value to the new node and it's previous value to
     * the focus node.
     *
     * @param item
     * @param priority
     * @throws QueueOverflowException
     */
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

    /**
     * Checks basic conditions first such as there only being 1 item, otherwise
     * sets the focus node to the first node and whilst there are still values
     * we loop. If the item's priority is greater than the current head, we
     * reassign head to that item otherwise we contionue the loop.
     *
     * @return item with highest priority
     * @throws QueueUnderflowException
     */
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

    /**
     * If there is only 1 item, we can safely set first to null. if not we call
     * the head method (thus assign the head to highest priority)and if it is
     * the first item, we assign first to the next item and set it's previous to
     * null.
     *
     * If it's not the first we need to check that items at different pointers
     * are not null and thus reassign next pointers to the previous pointer and
     * previous pointers to the next-next pointer.
     *
     * @throws QueueUnderflowException
     */
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

    /**
     * if the size is 0 then there are no items otherwise there are
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Although not following "convention" of brackets, this loops through all
     * values and outputs accordingly. This was much easier for testing
     *
     * @return
     */
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

    /**
     * set's the focus node to a specific item up until the specified "index"
     *
     * @param index
     */
    private void setFocus(int index) {
        focus = first;
        for (int i = 0; i < index - 1; i++) {
            focus = focus.getNext();
        }
    }

}
