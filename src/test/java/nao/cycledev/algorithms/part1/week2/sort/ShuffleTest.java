package nao.cycledev.algorithms.part1.week2.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShuffleTest {

    @Test
    public void test() {
        Integer[] array = new Integer[]{4, 8, 1, 7, 9, 34, 2, 1, 78, 3, 9};

        System.out.println(Arrays.toString(array));
        Shuffle.suffle(array);
        System.out.println(Arrays.toString(array));
    }

}