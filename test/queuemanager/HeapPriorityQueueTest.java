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
public class HeapPriorityQueueTest {

    HeapPriorityQueue heap = new HeapPriorityQueue(12);
    Person person1 = new Person("Jamie");
    Person person2 = new Person("Andrew");
    Person person3 = new Person("Rachel");
    Person person4 = new Person("Georgie");
    Person person5 = new Person("Matt");
    Person person6 = new Person("Thomas");

    /**
     * Test of add method, of class HeapPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        heap.add(person1, 10);
        heap.add(person2, 14);
        heap.add(person3, 16);
        heap.add(person4, 9);
     //   heap.add(person5, 7);
     //   heap.add(person6, 11);
     //   heap.add(new Person("Testing2"), 8);
       // heap.add(new Person("Testing2"), 15);
        //heap.add(new Person("Testing2"), 5);
        //heap.add(new Person("Testing2"), 6);
        //heap.add(new Person("Testing2"), 4);
        //heap.add(new Person("Testing2"),9);
        System.out.println(heap.toString());
        System.out.println(heap.tailIndex);

    }

    /**
     * Test of head method, of class HeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
    }

    /**
     * Test of swap method, of class HeapPriorityQueue.
     */
    @Test
    public void testSwap() {
    }

}
