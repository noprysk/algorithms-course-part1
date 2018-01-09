package nao.cycledev.algorithms.part1;

import edu.princeton.cs.algs4.StdRandom;

public class TestUtils {

    public static Integer[] generateIntArray(int n) {
        Integer[] result = new Integer[n];

        for (int i = 0; i < n; i++) {
            result[i] = StdRandom.uniform(n*10);
        }

        return result;
    }
}
