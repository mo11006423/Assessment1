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
 * @author 11006423
 */
public class SortedArrayPriorityQueueTest {

    public SortedArrayPriorityQueueTest() {
    }

    /**
     * Test of head method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
    }

    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
    }

    /**
     * Test of remove method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        SortedArrayPriorityQueue sor = new SortedArrayPriorityQueue(3);
        sor.add(new Person("Jamie"), 2);
        sor.add(new Person("Ryan"), 1);
        sor.add(new Person("Bob"), 3);
        System.out.println(sor.toString());
        sor.remove();
        System.out.println(sor.toString());
        sor.remove();
        System.out.println(sor.toString());
        sor.remove();
        System.out.println(sor.toString());

    }

    /**
     * Test of isEmpty method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
    }

    /**
     * Test of toString method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testToString() {
    }

}
