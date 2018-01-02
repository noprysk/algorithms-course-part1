package nao.cycledev.algorithms.part1.week2;

import org.junit.Test;

public class FixedCapacityStackTest {

    @Test
    public void testFixedCapacityStack() {

        long start = System.currentTimeMillis();
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);

        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            stack.pop();
        }

        System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
    }

}