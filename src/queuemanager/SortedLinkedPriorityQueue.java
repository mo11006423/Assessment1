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
       //TO be implemented
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
        String rtnVal = "";
        Node node = head;
        int i = 1;
        while (size >= i) {
            rtnVal = rtnVal + node.getItem().toString() + ", ";
            node = node.getNext();
            i++;
        }

        return rtnVal;

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
