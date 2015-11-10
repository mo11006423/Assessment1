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

    private int capacity, tailIndex;
    private HeapNode<T> leftChild;
    private HeapNode<T> rightChild;
    private HeapNode<T> head;
    private Object[] storage;

    public HeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.tailIndex = -1;
        storage = new Object[capacity];
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (isEmpty()) {
            storage[0] = new HeapNode<>(item, priority, null, null);
            head = ((HeapNode<T>) storage[0]);
        } else if (tailIndex == 0) {
            if (head.getPriority() < priority) {
                leftChild = head;
                head = new HeapNode<>(item, priority, leftChild, null);

            }
        }
        tailIndex++;
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
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }

}
