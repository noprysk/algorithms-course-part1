package nao.cycledev.algorithms.part1.week2;

import org.junit.Test;

public class LinkedQueueTest {

    @Test
    public void testLinkedQueue() {

        long start = System.currentTimeMillis();
        LinkedQueue<String> stack = new LinkedQueue<>();

        for (int i = 0; i < 100; i++) {
            stack.enqueue(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            stack.dequeue();
        }

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
    }

}