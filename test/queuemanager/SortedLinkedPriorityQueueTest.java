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
     */
    @Test
    public void testAdd() {
        Person person1 = new Person("Jamie");
        Person person2 = new Person("Andrew");
        sorted.add(person1, 1);
        System.out.println(sorted.toString());
        sorted.add(person2, 3);
        System.out.println(sorted.toString());
        sorted.add(new Person("Mum"), 5);
        System.out.println(sorted.toString());
        sorted.add(new Person("Dad"), -1);
        System.out.println(sorted.toString());
        sorted.add(new Person("Rocky"), 2);
        System.out.println(sorted.toString());
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
        assertTrue(sorted.isEmpty());
    }

    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
    }

}
