/**
 * This is the "Node" class for the heap. Basically identical to the Node for
 * the linked lists aside from the names being different.
 */
package queuemanager;

import java.util.Objects;

/**
 *
 * @author Jamie Simpson
 */
public class HeapNode<T> {

    private T item;
    private int priority;
    private HeapNode<T> leftChild;
    private HeapNode<T> rightChild;

    public HeapNode(T item, int priority, HeapNode leftChild, HeapNode rightChild) {
        this.item = item;
        this.priority = priority;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }

    public HeapNode<T> getLeftChild() {
        return leftChild;
    }

    public HeapNode<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(HeapNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(HeapNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.item);
        hash = 37 * hash + this.priority;
        hash = 37 * hash + Objects.hashCode(this.leftChild);
        hash = 37 * hash + Objects.hashCode(this.rightChild);
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
        final HeapNode<?> other = (HeapNode<?>) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (this.priority != other.priority) {
            return false;
        }
        if (!Objects.equals(this.leftChild, other.leftChild)) {
            return false;
        }
        if (!Objects.equals(this.rightChild, other.rightChild)) {
            return false;
        }
        return true;
    }

}
