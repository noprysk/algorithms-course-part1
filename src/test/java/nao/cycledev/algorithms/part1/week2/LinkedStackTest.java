package nao.cycledev.algorithms.part1.week2;

import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void testLinkedStack() {

        long start = System.currentTimeMillis();
        LinkedStack<String> stack = new LinkedStack<>();

        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            stack.pop();
        }

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
    }

}