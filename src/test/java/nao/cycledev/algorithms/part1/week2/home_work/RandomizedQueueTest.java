package nao.cycledev.algorithms.part1.week2.home_work;

import org.junit.Test;

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
        //System.out.println(queue);
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
        System.out.println(queue);
    }
}