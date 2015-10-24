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
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
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
