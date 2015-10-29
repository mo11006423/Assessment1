/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.Objects;

/**
 *
 * @author Spud101
 */
public class Node<T> {

    private T item;
    private int priority;
    private Node<T> next;

    public Node(T item, int priority, Node<T> next) {
        this.item = item;
        this.priority = priority;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.item);
        hash = 79 * hash + this.priority;
        hash = 79 * hash + Objects.hashCode(this.next);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (this.priority != other.priority) {
            return false;
        }
        return Objects.equals(this.next, other.next);
    }

}
