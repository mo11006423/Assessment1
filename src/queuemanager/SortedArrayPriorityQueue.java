package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using a sorted array for storage.
 *
 * Because Java does not allow generic arrays (!), this is implemented as an
 * array of Object rather than of Wrapper<T>, which would be natural. Array
 * elements accessed then have to be cast to Wrapper<T> before using their
 * getItem() or getPriority() methods. This is an example of Java's poor
 * implementation getting in the way. Java fanboys will no doubt explain at
 * length why it has to be this way, but note that Eiffel allows it because it
 * was done right from the start, rather than having generics tacked on as an
 * afterthought and limited by issues of backward compatibility. Hmph!
 *
 * @param <T>
 */
public class SortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public SortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((Wrapper<T>) storage[0]).getItem();
        }
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex == capacity - 1) {
            /* No resizing implemented, but that would be a good enhancement. */
            throw new QueueOverflowException();
        } else {
            tailIndex = tailIndex + 1;
            int i = tailIndex;
            while (i > 0 && ((Wrapper<T>) storage[i - 1]).getPriority() < priority) {
                storage[i] = storage[i - 1];
                i = i - 1;
            }
            storage[i] = new Wrapper<>(item, priority);
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < tailIndex; i++) {
                storage[i] = storage[i + 1];
            }
            tailIndex = tailIndex - 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex <= -1;
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
