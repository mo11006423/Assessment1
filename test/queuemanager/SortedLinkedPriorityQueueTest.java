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

    public SortedLinkedPriorityQueueTest() {
    }

    /**
     * Test of head method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() {
    }

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     *
     * This method test that when items are added already in the correct order
     * of priority that the linked list stores them in that order. It test by
     * adding 5 people individually with priorities from 5-1 then checks that
     * the item stored at the indexes 0-4 are the highest to lowest priorities
     *
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testAddCorrectOrder() throws QueueUnderflowException {
        Person person1 = new Person("Jamie");
        Person person2 = new Person("Rachel");
        Person person3 = new Person("Georgie");
        sorted.add(person1, 1);
        sorted.add(person2, 2);
  //      sorted.add(person3, -2);
        //    sorted.add(new Person("Louis"), 1);
        System.out.println(sorted.toString());

    }

    /**
     * This method tests that items added in reverse order (priority 1 through
     * to 5) are pushed back along the queue and so the highest priority is
     * always first, at index 0. IN this scenario prioirty 5 will finish at the
     * top (head) of the queue
     */
    @Test
    public void testAddReverseOrder() {

    }

    /**
     * This method is used to test that when items of random priorities are
     * added that they are in the correct place.Highest number which represents
     * the highest priority is at the head (index 0) and lowest number (lowest
     * priority) is at the tail
     */
    @Test
    public void testRandomOrder() {

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
