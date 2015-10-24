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
            for (int i = 0; i <= tail; i++) {
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
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (headIndex() == tail) {
            storage[headIndex()] = null;
            tail--;
        } else {
            storage[headIndex()] = storage[tail];
            tail--;
        }
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tail; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }

    private int headIndex() throws QueueUnderflowException {
        int index = -1;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i <= tail; i++) {
                Wrapper<T> item = (Wrapper<T>) storage[i];
                if (item == head()) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public Object[] getStorage() {
        return storage;
    }
}
