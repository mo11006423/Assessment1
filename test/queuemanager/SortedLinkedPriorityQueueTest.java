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
public class SortedLinkedPriorityQueueTest {

    SortedLinkedPriorityQueue sorted = new SortedLinkedPriorityQueue();
    Person person1 = new Person("Jamie");
    Person person2 = new Person("Rachel");
    Person person3 = new Person("Georgie");

    public SortedLinkedPriorityQueueTest() {
    }

    /**
     * Test of head method, of class SortedLinkedPriorityQueue. Although this is
     * essentially tested through the add methods as well, that is to show that
     * add is adding in the correct order. This will focus on testing the when
     * an item is added with lower priority it is not the head and higher
     * priority becomes the head
     */
    @Test
    public void testHead() throws QueueUnderflowException {
        sorted.add(person1, 2);
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person2, 1);
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person3, 3);
        assertEquals(sorted.head().toString(), "Georgie");
        sorted.add(new Person("Thomas"), 4);
        assertEquals(sorted.head().toString(), "Thomas");
    }

    /**
     * Tests that an exception is thrown when the head is empty
     *
     * @throws QueueUnderflowException
     */
    @Test(expected = QueueUnderflowException.class)
    public void testHeadUnderflow() throws QueueUnderflowException {
        sorted.head();
    }

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     *
     * This method test that when items are added already in the correct order
     * of priority that the linked list stores them in that order. It test by
     * adding 4 people individually with priorities from 4-1 then checks that
     * the item stored at the indexes 0-4 are the highest to lowest priorities
     *
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testAddCorrectOrder() throws QueueUnderflowException {
        assertTrue(sorted.isEmpty());
        sorted.add(person1, 4);
        assertEquals(sorted.toString(), ("Jamie"));
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person2, 3);
        assertEquals(sorted.toString(), "Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person3, 2);
        assertEquals(sorted.toString(), "Jamie, Rachel, Georgie");
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(new Person("Thomas"), 1);
        assertEquals(sorted.toString(), "Jamie, Rachel, Georgie, Thomas");
        assertEquals(sorted.head().toString(), "Jamie");
        //  System.out.println(sorted.toString());
    }

    /**
     * This method tests that items added in reverse order (priority 1 through
     * to 4) are pushed back along the queue and so the highest priority is
     * always first, at index 0. In this scenario priority 4 will finish at the
     * top (head) of the queue
     */
    @Test
    public void testAddReverseOrder() throws QueueUnderflowException {
        assertTrue(sorted.isEmpty());
        sorted.add(person1, 1);
        assertEquals(sorted.toString(), ("Jamie"));
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person2, 2);
        assertEquals(sorted.toString(), "Rachel, Jamie");
        assertEquals(sorted.head().toString(), "Rachel");
        sorted.add(person3, 3);
        assertEquals(sorted.toString(), "Georgie, Rachel, Jamie");
        assertEquals(sorted.head().toString(), "Georgie");
        sorted.add(new Person("Thomas"), 4);
        assertEquals(sorted.toString(), "Thomas, Georgie, Rachel, Jamie");
        assertEquals(sorted.head().toString(), "Thomas");
    }

    /**
     * This method is used to test that when items of random priorities are
     * added that they are in the correct place.Highest number which represents
     * the highest priority is at the head (index 0) and lowest number (lowest
     * priority) is at the tail
     */
    @Test
    public void testRandomOrder() throws QueueUnderflowException {
        assertTrue(sorted.isEmpty());
        sorted.add(person1, 2);
        assertEquals(sorted.toString(), "Jamie");
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person2, 1);
        assertEquals(sorted.toString(), "Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Jamie");
        sorted.add(person3, 5);
        assertEquals(sorted.toString(), "Georgie, Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Georgie");
        sorted.add(new Person("Thomas"), 6);
        assertEquals(sorted.toString(), "Thomas, Georgie, Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Thomas");
        sorted.add(new Person("Martin"), 4);
        assertEquals(sorted.toString(), "Thomas, Georgie, Martin, Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Thomas");
        sorted.add(new Person("Ryan"), 3);
        assertEquals(sorted.toString(), "Thomas, Georgie, Martin, Ryan, Jamie, Rachel");
        assertEquals(sorted.head().toString(), "Thomas");
        //  System.out.println(sorted.toString());

    }

    /**
     * Test of remove method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() {
    }

    /**
     * Test of isEmpty method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
    }

    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
    }

}
