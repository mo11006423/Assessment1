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
public class UnsortedLinkedPriorityQueueTest {

    UnsortedLinkedPriorityQueue unsorted = new UnsortedLinkedPriorityQueue();
    Person person1 = new Person("Jamie");
    Person person2 = new Person("Andrew");
    Person person3 = new Person("Jeff");

    public UnsortedLinkedPriorityQueueTest() {
    }

    /**
     * Test of add method, of class UnsortedLinkedPriorityQueue.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAdd() throws Exception {
        unsorted.add(person1, 2);
        unsorted.add(person2, 1);
        unsorted.add(person3, 3);
        System.out.println("All people " + unsorted.toString());
        System.out.println("Current head " + unsorted.head());
        unsorted.remove();
        System.out.println("After 1 remove " + unsorted.toString());

    }

    /**
     * Test of head method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
    }

    /**
     * Test of remove method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
    }

    /**
     * Test of isEmpty method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
    }

}
