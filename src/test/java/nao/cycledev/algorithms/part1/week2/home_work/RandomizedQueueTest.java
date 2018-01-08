package nao.cycledev.algorithms.part1.week2.home_work;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    @Test
    public void enqueueTest() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(23);
        queue.enqueue(7);
        queue.enqueue(12);
        queue.enqueue(6);

        assertEquals(6, queue.size());
    }

    @Test
    public void dequeueTest() {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(23);
        queue.enqueue(7);
        queue.enqueue(12);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(2, queue.size());
    }

    @Test
    public void iteratorTest() {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(23);
        queue.dequeue();
        queue.enqueue(7);
        queue.enqueue(12);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(11);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(5);
        queue.dequeue();

        assertEquals(6, queue.size());

        Iterator<Integer> iterator = queue.iterator();
        System.out.print("[");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
}