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
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    private int size;
    private final Object[] storage;
    private int tailIndex;

    public HeapPriorityQueue(int size) {
        this.size = size;
        storage = new Object[size];
        tailIndex = -1;
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
        return tailIndex == -1;
    }

}
