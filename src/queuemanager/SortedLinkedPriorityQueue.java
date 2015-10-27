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
        if (storage.size() == 0) {
            storage.add(new Wrapper<>(item, priority));
        } else if (priority > (storage.get(0).getPriority())) {
            storage.add(0, new Wrapper<>(item, priority));
        } else if (priority < (storage.getLast().getPriority())) {
            storage.addLast(new Wrapper<>(item, priority));
        } else {
            for (int i = 0; i < storage.size(); i++) {
                if (((storage.get(i).getPriority()) - priority) < 0) {
                    storage.add(i, new Wrapper<>(item, priority));
                    break;
                }
            }
        }
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
        return storage.toString();
    }

}
