/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Jamie Simpson
 * @param <T>
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    private final Object[] storage;
    private final int capacity;
    private final int tail;

    public UnsortedArrayPriorityQueue(int capacity) {
        storage = new Object[capacity];
        this.capacity = capacity;
        tail = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        //To be implemented
        return null;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        //To be implemented
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

    @Override
    public String toString() {
        //To be implemented
        return null;
    }
}
