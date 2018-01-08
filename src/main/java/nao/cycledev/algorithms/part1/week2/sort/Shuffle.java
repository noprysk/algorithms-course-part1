package nao.cycledev.algorithms.part1.week2.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {

    public static void suffle(Object[] a) {

        int n = a.length;

        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(i + 1);
            SortUtils.swap(a, i, r);
        }
    }
}
