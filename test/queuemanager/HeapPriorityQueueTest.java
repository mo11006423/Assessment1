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

    HeapPriorityQueue heap = new HeapPriorityQueue(6);
    Person person1 = new Person("Jamie");
    Person person2 = new Person("Andrew");
    Person person3 = new Person("Rachel");
    Person person4 = new Person("Georgie");
    Person person5 = new Person("Matt");
    Person person6 = new Person("Thomas");

    /**
     * Test of add method, of class HeapPriorityQueue. Understandably more tests
     * could be done on this front.
     */
    @Test
    public void testAdd() throws Exception {
        assertTrue(heap.isEmpty());
        heap.add(person1, 1);
        assertFalse(heap.isEmpty());
        assertEquals(heap.toString(), "[Jamie: 1], ");
        heap.add(person2, 2);
        assertEquals(heap.toString(), "[Andrew: 2], [Jamie: 1], ");
        heap.add(person3, 4);
        assertEquals(heap.toString(), "[Rachel: 4], [Jamie: 1], [Andrew: 2], ");
        heap.add(person4, 3);
        assertEquals(heap.toString(), "[Rachel: 4], [Georgie: 3], [Jamie: 1], [Andrew: 2], ");
        heap.add(person5, 7);
        assertEquals(heap.toString(), "[Matt: 7], [Rachel: 4], [Georgie: 3], [Jamie: 1], [Andrew: 2], ");
        heap.add(person6, 5);
        assertEquals(heap.toString(), "[Matt: 7], [Thomas: 5], [Rachel: 4], [Georgie: 3], [Jamie: 1], ");
        System.out.println(heap.toString());
    }

    /**
     * Test of head method, of class HeapPriorityQueue. Tests that every time a
     * smaller priority is added that the head is NOT overwritten and that when
     * a higher priority is added that the head is changed and switched to
     * somewhere else
     */
    @Test
    public void testHead() throws Exception {
        heap.add(person1, 3);
        assertEquals("(Jamie, 3)", heap.head().toString());
        heap.add(person2, 2);
        assertEquals("(Jamie, 3)", heap.head().toString());
        heap.add(person3, 1);
        assertEquals("(Jamie, 3)", heap.head().toString());
        heap.add(person4, 4);
        assertEquals("(Georgie, 4)", heap.head().toString());
        heap.add(person5, 5);
        assertEquals("(Matt, 5)", heap.head().toString());

    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        heap.add(person1, 5);
        heap.add(person2, 16);
        heap.add(person3, 13);
        heap.add(person4, 6);
        heap.add(person5, 15);
        heap.add(person6, 4);
        assertEquals("[Andrew: 16], [Matt: 15], [Georgie: 6], [Jamie: 5], [Rachel: 13], [Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("[Matt: 15], [Rachel: 13], [Jamie: 5], [Georgie: 6], [Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("[Rachel: 13], [Jamie: 5], [Georgie: 6], [Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("[Georgie: 6], [Jamie: 5], [Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("[Jamie: 5], [Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("[Thomas: 4], ", heap.toString());
        heap.remove();
        assertEquals("", heap.toString());
        assertTrue(heap.isEmpty());
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue. Tests that upon
     * initialisation that the heap is empty. Then adds an item to test it's not
     * empty, removes the item to test is empty again and finally adds 2 items
     * and checks the conditions for each remove call
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException, QueueUnderflowException {
        assertTrue(heap.isEmpty());
        heap.add(person1, 1);
        assertFalse(heap.isEmpty());
        heap.remove();
        assertTrue(heap.isEmpty());
        heap.add(person1, 3);
        heap.add(person2, 5);
        assertFalse(heap.isEmpty());
        heap.remove();
        assertFalse(heap.isEmpty());
        heap.remove();
        assertTrue(heap.isEmpty());

    }

}
