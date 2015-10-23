/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.Arrays;

/**
 *
 * @author Jamie Simpson
 * @param <T>
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    private final Object[] storage;
    private final int capacity;
    private int tail;

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
        if (tail == capacity - 1) {
            throw new QueueOverflowException();
        } else {
            tail++;
            storage[tail] = new Wrapper<>(item, priority);
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        //To be implemented
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }
}
