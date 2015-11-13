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

    private Object[] storage;
    private final int capacity;
    private int tail;

    public UnsortedArrayPriorityQueue(int capacity) {
        storage = new Object[capacity];
        this.capacity = capacity;
        tail = -1;
    }

    /**
     * Checks if the queue is empty and when its not we set the value we want to
     * return to the first stored item and then compare the priorities of every
     * other item, replacing the rtnVal with any priority that is greater than
     * its current value
     *
     * @return rtnVal (item with highest priority)
     * @throws QueueUnderflowException
     */
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

    /**
     * Cannot add items beyond the capacity of the array which is checked first.
     * Then the tail is incremented and the item added on to the end as no
     * sorting is required.
     *
     * @param item
     * @param priority
     * @throws QueueOverflowException
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tail == capacity - 1) {
            throw new QueueOverflowException();
        } else {
            tail++;
            storage[tail] = new Wrapper<>(item, priority);
        }
    }

    /**
     * Checks if there are items to be removed. If there are items to be removed
     * we find the index of the head item and compare it to that of the tail, if
     * it's at the end it is then set to null and the tail decremented.
     *
     * If it's not at that position, we resize the array, move it to the end and
     * set it to null. We then desize the array and decrement the tail.
     *
     * This is a very clunky way of doing it and not very professional but lack
     * of time made me do it!
     *
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (headIndex() == tail) {
            storage[headIndex()] = null;
            tail--;
        } else {
            resize();
            storage[headIndex()] = storage[tail];
            storage[tail] = null;
            desize();
            tail--;

        }
    }

    /**
     * Self explanatory.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    /**
     * Overrides the toString method outputting the values in a set of square
     * brackets
     *
     * @return result (All values stored)
     */
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

    /**
     * Returns the index of the item with the highest priority. this is a helper
     * method and does so by starting at the bottom and working its way through
     * the indexes till the highest is located.
     *
     * @return index (of item)
     * @throws QueueUnderflowException
     */
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

    /**
     * Resizes the array in order to bypass a problem as opposed to fixing it
     * #ProfessionalDeveloperProblems
     */
    public void resize() {
        //  System.out.println(storage.length);
        storage = Arrays.copyOf(storage, capacity + 1);
        //  System.out.println(storage.length);
    }

    /**
     * A very clunky piece of code that I'm ashamed I wrote! Changes the array
     * back to the previous size.
     */
    public void desize() {
        storage = Arrays.copyOf(storage, capacity);
    }
}
