/**
 * This is the heap priority queue. In this class items added are in order where
 * children do not have a higher priority than their parents.
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
                System.out.println("Parent index " + parentIndex);
                while (parentIndex > 1 && priority > ((Wrapper<T>) storage[parentIndex]).getPriority()) {
                    System.out.println("Parent index " + parentIndex);
                    parentIndex = (int) Math.round((parentIndex / 2.0) - 1.0);
                    i--;
                }
                if (parentIndex == 0) {
                    parentIndex = 1;
                }
                System.out.println("Parent index " + parentIndex);
                while (i > parentIndex) {
                    storage[i] = storage[i - 1];
                    i--;
                }
                storage[parentIndex] = new Wrapper<>(item, priority);

            }

        }

    }

    @Override
    public T head() throws QueueUnderflowException {
        return (T) storage[0];
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i;
            if (((Wrapper<T>) storage[1]).getPriority() < ((Wrapper<T>) storage[2]).getPriority()) {
                storage[0] = storage[2];
                i = 2;
            } else {
                i = 0;
                while (i < tailIndex && storage[i] != null) {
                    storage[i] = storage[i + 1];
                    i++;
                }
            }
            tailIndex--;
        }
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
                result = result + "[" + ((Wrapper<T>) item).getItem().toString() + ": " + ((Wrapper<T>) item).getPriority() + "], ";
            }
        }
        return result;
    }

}
