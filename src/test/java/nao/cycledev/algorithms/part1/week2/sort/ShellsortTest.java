package nao.cycledev.algorithms.part1.week2.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShellsortTest {

    @Test
    public void test () {
        Integer[] expected = {1, 1, 2, 3, 4, 7, 8, 9, 9, 34, 78};
        Integer[] array = new Integer[]{4, 8, 1, 7, 9, 34, 2, 1, 78, 3, 9};

        Shellsort.sort(array);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual:   " + Arrays.toString(array));

        assertArrayEquals(expected, array);
    }

}