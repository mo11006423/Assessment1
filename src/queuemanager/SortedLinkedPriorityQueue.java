/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Jamie Simpson
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    private Node<T> head; //Node at the top (highest priority)
    private Node<T> previous; //previous node
    private Node<T> focus; //current
    private Node<T> next;
    private int size;

    public SortedLinkedPriorityQueue() {
        head = null;
        previous = null;
        focus = null;
        size = 0;
    }

    /**
     * This method checks if the queue is empty before returning the item with
     * the highest priority in the list.
     *
     * @return item at the top of the list
     * @throws QueueUnderflowException
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return head.getItem();
    }

    /**
     * This method firstly checks if the queue is empty and if it is sets the
     * head equal to the new node. There is no next item and no previous item.
     * it then checks if the next item will be the second item and if its
     * greater priority it switches the head and the new item around, setting
     * the next and previous pointers accordingly. if the size is greater than
     * one then we want to set the focus to the last position in the list. if
     * thew new priority is then less than this priority we set the next node of
     * the last item to the new item.
     *
     * If it is greater than the head, these items are then moved around
     * accordingly and for any other scenario, node priorities are looped
     * through checking to find the position before then seting next and
     * previous pointers accordingly.
     *
     * Example: 4 7 9 and we now want to add 8, 7's next pointer would be set to
     * 8, 9's previous pointer would be set to 8 and 8's previous set to 7 and
     * 8's next set to 9.
     *
     * [Gets very confusing]
     *
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority) {
        if (isEmpty()) {
            head = new Node<>(item, priority, null, null);
        } else if (size == 1) {
            if (priority > head.getPriority()) {
                next = head;
                head = new Node<>(item, priority, next, null);
                next.setPrevious(head);
            } else {
                next = new Node<>(item, priority, null, head);
                head.setNext(next);
            }
        } else if (size > 1) {
            setFocus(size);
            if (priority < focus.getPriority()) {
                focus.setNext(new Node<>(item, priority, null, focus));
            } else if (priority > head.getPriority()) {
                next = head;
                head = new Node<>(item, priority, next, null);
                next.setPrevious(head);
            } else {
                focus = head;
                for (int i = 0; i < size; i++) {
                    if (priority > focus.getPriority()) {
                        next = focus;
                        previous = focus.getPrevious();
                        Node<T> newItem = new Node<>(item, priority, next, previous);
                        previous.setNext(newItem);
                        next.setPrevious(newItem);
                        break;
                    } else {
                        focus = focus.getNext();
                    }
                }
            }
        }

        size++;
    }

    /**
     * Checks if there are items to be removed and sets the head equal to the
     * next item erasing itself.
     *
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (size == 1) {
            head = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
    }

    /**
     * size is only ever 0 when empty to return boolean of size = 0
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return all the stored values as a string by setting the focus node to
     * head and looping through different scenarios until there are no more
     * items.
     */
    @Override
    public String toString() {
        focus = head;
        String output = "";
        int counter = 0;
        while (focus != null) {
            counter++;
            if (size == 1) {
                output += focus.getItem().toString();
                break;
            } else if (counter == size) {
                output += focus.getItem().toString();
                break;
            } else {
                output += focus.getItem().toString() + ", ";
                focus = focus.getNext();
            }
        }
        return output;
    }

    public int size() {
        return size;
    }

    /**
     * A helper method that is used to set the focus node (the node we would
     * currently be on) to the last item stored.
     *
     * @param index
     */
    private void setFocus(int index) {
        focus = head;
        for (int i = 0; i < index - 1; i++) {
            focus = focus.getNext();
        }
    }
}
