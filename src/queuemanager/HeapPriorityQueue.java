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

    public int capacity, tailIndex;
    private Object[] storage;

    public HeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.tailIndex = -1;
        storage = new Object[capacity];
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (isEmpty()) {
            storage[0] = new Wrapper<>(item, priority);
            tailIndex++;
        } else if (tailIndex == 0 || tailIndex == 1) {
            tailIndex++;
            if (priority > ((Wrapper<T>) storage[0]).getPriority()) {
                storage[tailIndex] = storage[0];
                storage[0] = new Wrapper<>(item, priority);
            } else {
                storage[tailIndex] = new Wrapper<>(item, priority);
            }
        } else {
            tailIndex++;
            double tailAsDouble = tailIndex / 2.0 * 2.0;
            if (tailIndex % 2 != 0) {
                int parentIndex = (int) Math.round((tailAsDouble / 2) - 1);
                if (priority > ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                    storage[tailIndex] = storage[parentIndex];
                    storage[parentIndex] = new Wrapper<>(item, priority);
                } else {
                    storage[tailIndex] = new Wrapper<>(item, priority);
                }

            } else {
                int parentIndex = (int) Math.round((tailAsDouble / 2) - 2);
                if (priority > ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                    storage[tailIndex] = storage[parentIndex];
                    storage[parentIndex] = new Wrapper<>(item, priority);
                } else {
                    storage[tailIndex] = new Wrapper<>(item, priority);
                }
            }
        }

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

    @Override
    public String toString() {
        String result = "";
        for (Object item : storage) {
            if (item != null) {
                result = result + " " + ((Wrapper<T>) item).getItem().toString() + " " + ((Wrapper<T>) item).getPriority();
            }
        }
        return result;
    }

}
