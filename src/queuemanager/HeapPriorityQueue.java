/**
 * This is the heap priority queue. In this class items added are in order where
 * children do not have a higher priority than their parents.
 */
package queuemanager;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jamie Simpson
 * @param <T>
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    public int capacity, tailIndex;
    private Object[] storage;

    //Constructor
    public HeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.tailIndex = -1;
        storage = new Object[capacity];
    }

    /**
     * An incredibly messy method which should probably be re-written This
     * method checks the 4 major conditions first before continuing. These are
     *
     * 1 - that the array is empty and we can just add a new item and increment
     * the tail 2- that the array will not overflow (is not full before adding)
     * 3 - that if the item added is either the first or second second they have
     * their priorities checked and then switched with the top of the array if
     * either is larger, if not they are just added on 4- that the object added
     * after the first 3 is not greater than the head. If it is it can just be
     * added and everything shifted 1 space forward if not it has to be checked.
     *
     * The last else checks that the item, following the algorithm and
     * converting values to double (in order for rounding to be applied upwards,
     * not downwards) is greater or less than any of its parents or
     * predecessors. it is then inserted accordingly based on its value. Since
     * the head is always checked, if the parent value comes Back as 0 we have
     * to assume that it is less than the head but bigger than its first parent
     * and so parentIndex is set to 1 before shifting everything up 1 place in
     * the array.
     *
     * @param item
     * @param priority
     * @throws QueueOverflowException
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (isEmpty()) {
            storage[0] = new Wrapper<>(item, priority);
            tailIndex++;
        } else if (tailIndex == capacity - 1) {
            throw new QueueOverflowException();
        } else if (tailIndex == capacity) {
            throw new QueueOverflowException();
        } else if (tailIndex == 0 || tailIndex == 1) {
            tailIndex++;
            if (priority > ((Wrapper<T>) storage[0]).getPriority()) {
                storage[tailIndex] = storage[0];
                storage[0] = new Wrapper<>(item, priority);
            } else {
                storage[tailIndex] = new Wrapper<>(item, priority);
            }
        } else if (priority > ((Wrapper<T>) storage[0]).getPriority()) {
            tailIndex++;
            int i = tailIndex;
            while (i > 0) {
                storage[i] = storage[i - 1];
                i--;
            }
            storage[0] = new Wrapper<>(item, priority);
        } else {
            tailIndex++;
            double tailAsDouble = tailIndex / 2.0 * 2.0;
            int parentIndex = (int) Math.round((tailAsDouble / 2) - 1);
            //      System.out.println("Parent " + parentIndex);
            //      System.out.println(((Wrapper<T>) storage[parentIndex]).getPriority());
            if (priority < ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                storage[tailIndex] = new Wrapper<>(item, priority);
            } else {
                int i = tailIndex;
                //     System.out.println("Parent index " + parentIndex);
                while (parentIndex > 1 && priority > ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                    //     System.out.println("Parent index " + parentIndex);
                    parentIndex = (int) Math.round((parentIndex / 2.0) - 1.0);
                    i--;
                }
                if (parentIndex == 0) {
                    parentIndex = 1;
                }
                //     System.out.println("Parent index " + parentIndex);
                while (i > parentIndex) {
                    storage[i] = storage[i - 1];
                    i--;
                }
                storage[parentIndex] = new Wrapper<>(item, priority);

            }

        }

    }

    /**
     * This method returns the item stored at position 0 in the array as this
     * will always be the highest priority item.
     *
     * @return
     * @throws QueueUnderflowException
     */
    @Override
    public T head() throws QueueUnderflowException {
        return (T) storage[0];
    }

    /**
     * This method checks which of the original children is greatest and
     * switches that to position 0 if it is the second. We go through a loop
     * creating a new subset where every item is just moved back a single
     * position in the array (thus removing the head). This causes issues as
     * certain situations occur where the child could have a higher priority
     * than the new parent. This is then taken care of within the new subset by
     * looping and comparing children with their parents. If the child has a
     * greater priority, it is swapped.
     *
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if (tailIndex == 0) {
            storage[0] = null;
            tailIndex--;
        } else if (tailIndex == 1) {
            storage[0] = storage[1];
            storage[1] = null;
            tailIndex--;
        } else {
            int i;
            if (((Wrapper<T>) storage[1]).getPriority() < ((Wrapper<T>) storage[2]).getPriority()) {
                storage[0] = storage[2];
                i = 2;
            } else {
                i = 0;
            }
            while (i < tailIndex && storage[i] != null) {
                storage[i] = storage[i + 1];
                i++;
            }
            //Fix for "grandchild older than grandparent" scenario
            storage[tailIndex] = null;
            tailIndex--;
            for (int j = tailIndex; j > 0; j--) {
                int parentIndex = (int) Math.round(j / 2.0 - 1);
                //System.out.println(parentIndex);
                if (((Wrapper<T>) storage[j]).getPriority() > ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                    Object[] tempStore = new Object[1];
                    tempStore[0] = storage[parentIndex];
                    storage[parentIndex] = storage[j];
                    storage[j] = tempStore[0];
                }
            }

        }
    }

    /**
     * Since tailIndex is set to -1 upon initialisation and never reaches -1
     * until the last item is removed, we can return true or false based on if
     * it is -1 or not
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return tailIndex == -1;
    }

    /**
     * Puts the string in brackets along with its priority by looping through
     * every item in the array where it is not null
     *
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        for (Object item : storage) {
            if (item != null) {
                result = result + "[" + ((Wrapper<T>) item).getItem().toString() + ": " + ((Wrapper<T>) item).getPriority() + "], ";
            }
        }
        return result;
    }

}
