package nao.cycledev.algorithms.part1.week3;

import nao.cycledev.algorithms.part1.TestUtils;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void sortTest() {

        Integer[] expected = {1, 1, 2, 3, 4, 7, 8, 9, 9, 34, 78};
        Integer[] array = new Integer[]{4, 8, 1, 7, 9, 34, 2, 1, 78, 3, 9};

        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));

        assertArrayEquals(expected, array);
    }

    @Test
    public void sortTest2() {
        Integer[] array = TestUtils.generateIntArray(100);

        System.out.println(Arrays.toString(array));

        MergeSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}