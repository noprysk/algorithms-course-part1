package nao.cycledev.algorithms.part1.week2;

import org.junit.Test;

public class ResizingArrayStackTest {

    @Test
    public void testResizingArrayStack() {

        long start = System.currentTimeMillis();
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(10);

        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            stack.pop();
        }

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
    }

}