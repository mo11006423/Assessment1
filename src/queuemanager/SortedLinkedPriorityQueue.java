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

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return head.getItem();
    }

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

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (size == 1) {
            head = null;
        } else {
            head = head.getNext();
        }
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    private void setFocus(int index) {
        focus = head;
        for (int i = 0; i < index - 1; i++) {
            focus = focus.getNext();
        }
    }
}
