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
        } else if (size == 1 && priority > head.getPriority()) {
            previous = head;
            head = new Node<>(item, priority, previous, null);
        } else if (size == 1 && priority < head.getPriority()) {
            previous = head;
            head.setNext((new Node<>(item, priority, null, previous)));
        } else if (size > 1 && priority > head.getPriority()) {
            next = head.getNext();
            previous = head;
            head = new Node<>(item, priority, previous, null);
            previous.setNext(next);
            previous.setPrevious(head);
        } else if (size > 1 && priority < head.getPriority()) {

        }
        size++;
    }

    @Override
    public void remove() {
        //To be implemented

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        focus = head;
        String output = "";
        while (focus != null) {
            output += focus.getItem().toString() + ", ";
            focus = focus.getNext();
        }
        return output;
    }

    public int size() {
        return size;
    }

    public void setFocus(int index) {
        focus = head;
        previous = null;
        for (int i = 1; i < index; i++) {
            previous = focus;
            focus = focus.getNext();
        }
    }
}
