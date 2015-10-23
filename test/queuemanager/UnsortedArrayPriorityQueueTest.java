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

    public UnsortedArrayPriorityQueueTest() {
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
         UnsortedArrayPriorityQueue sor = new UnsortedArrayPriorityQueue(3);
        sor.add(new Person("Jamie"), 2);
        sor.add(new Person("Ryan"), 1);
        sor.add(new Person("Bob"), 3);
        System.out.println(sor.toString());
        System.out.println(sor.head());
        sor.remove();
        System.out.println(sor.toString());
        System.out.println(sor.head());


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
