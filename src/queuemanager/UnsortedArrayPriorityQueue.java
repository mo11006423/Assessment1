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
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            Wrapper<T> rtnVal = (Wrapper<T>) storage[0];
            for (int i = 0; i < capacity; i++) {
                Wrapper<T> item = (Wrapper<T>) storage[i];
                if (item.getPriority() > rtnVal.getPriority()) {
                    rtnVal = item;
                }
            }
            return (T) rtnVal;
        }
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
        Wrapper<T> highestPriority = (Wrapper<T>) storage[0];
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            Wrapper<T> item = (Wrapper<T>) storage[i];
            if (item.getPriority() > highestPriority.getPriority()) {
                highestPriority = item;
                index = i;
            }
        }
        //Now we know the item to remove and its position is highestPriority
        if (index == capacity - 1) {
            storage[index] = new Wrapper<>(null, -1);
        } else {
            storage[index] = storage[index + 1];
        }
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
