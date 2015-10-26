/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.LinkedList;

/**
 *
 * @author Jamie Simpson
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    private LinkedList<Wrapper> storage = new LinkedList<>();

    public SortedLinkedPriorityQueue() {
    }

    @Override
    public T head() {
        //To be implemented
        return null;
    }

    @Override
    public void add(T item, int priority) {
        //To be implemented

    }

    @Override
    public void remove() {
        //To be implemented

    }

    @Override
    public boolean isEmpty() {
        return storage.size() == 0;
    }

    @Override
    public String toString() {
        //To be implemented
        return null;
    }

}
