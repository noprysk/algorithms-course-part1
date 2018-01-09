package nao.cycledev.algorithms.part1.week3;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortBottomUpTest {

    @Test
    public void sortTest() {

        Integer[] expected = {1, 1, 2, 3, 4, 7, 8, 9, 9, 34, 78};
        Integer[] array = new Integer[]{4, 8, 1, 7, 9, 34, 2, 1, 78, 3, 9};

        MergeSortBottomUp.sort(array);
        System.out.println(Arrays.toString(array));

        assertArrayEquals(expected, array);
    }

}