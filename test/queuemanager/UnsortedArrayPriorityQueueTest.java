/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jamie Simpson
 */
public class UnsortedArrayPriorityQueueTest {

    //Set up an instance variable of the UnsortedArrayPriorityQueue class
    private UnsortedArrayPriorityQueue unsorted;

    public UnsortedArrayPriorityQueueTest() {
    }

    /**
     * This method tests the capacity (how many items can be stored) within the
     * object array. The unsorted array variable is set to different lengths,
     * starting with 5 and moving down to . it is then asserted that that value
     * is equal to the length of the storage variable, accessed through a get
     * method in the UnsortedArrayPriorityQueue class.
     *
     * The method also tests that the correct exception is thrown if a negative
     * number is entered as the size.
     *
     */
    @Test(expected = NegativeArraySizeException.class)
    public void testCapacity() {
        unsorted = new UnsortedArrayPriorityQueue(5);
        assertEquals(5, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(4);
        assertEquals(4, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(3);
        assertEquals(3, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(2);
        assertEquals(2, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(1);
        assertEquals(1, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(0);
        assertEquals(0, unsorted.getStorage().length);
        unsorted = new UnsortedArrayPriorityQueue(-1);

    }

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {

    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {

    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue. This method
     * will test that upon creating an instance of the
     * UnsortedArrayPriorityQueue class, that the array is empty. Upon adding
     * values the array will be testing to not be empty.
     *
     * Single additions, multiple additions and re-additions are all used to
     * test the different state of isEmpty.
     *
     * @throws queuemanager.QueueOverflowException
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException, QueueUnderflowException {
        //Capacity for 3 (odd number)
        unsorted = new UnsortedArrayPriorityQueue(3);
        //No values yet added
        assertTrue(unsorted.isEmpty());
        //Capacity for 4 (even number)
        unsorted = new UnsortedArrayPriorityQueue(4);
        //Empty as no values added
        assertTrue(unsorted.isEmpty());
        //Large number - Java vm throws error at peak integer value so last digit removed
        unsorted = new UnsortedArrayPriorityQueue(214748364);
        assertTrue(unsorted.isEmpty());
        //Testing 0 size
        unsorted = new UnsortedArrayPriorityQueue(0);
        assertTrue(unsorted.isEmpty());
        //New queue for 1 person
        unsorted = new UnsortedArrayPriorityQueue(1);
        //check is empty
        assertTrue(unsorted.isEmpty());
        //add person
        unsorted.add(new Person("Test Person"), 1);
        //check is not empty
        assertFalse(unsorted.isEmpty());
        //Remove person
        unsorted.remove();
        //check is empty again
        assertTrue(unsorted.isEmpty());
        //New queue for 3 people
        unsorted = new UnsortedArrayPriorityQueue(3);
        //check with 3 people
        unsorted.add(new Person("Test Person1"), 3);
        unsorted.add(new Person("Test Person2"), 1);
        unsorted.add(new Person("Test Person3"), 2);
        assertFalse(unsorted.isEmpty());
        //Remove 1 person (still 2 people)
        unsorted.remove();
        assertFalse(unsorted.isEmpty());
        //Remove 2nd person
        unsorted.remove();
        assertFalse(unsorted.isEmpty());
        //Remove 3rd person (now empty)
        unsorted.remove();
        assertTrue(unsorted.isEmpty());
        unsorted.add(new Person("New person same instance"), 4);
        assertFalse(unsorted.isEmpty());

    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     *
     * @throws queuemanager.QueueOverflowException
     */
    @Test
    public void testToString() throws QueueOverflowException {

    }

}
