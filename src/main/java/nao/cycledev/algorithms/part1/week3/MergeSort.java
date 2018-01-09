package nao.cycledev.algorithms.part1.week3;

import nao.cycledev.algorithms.part1.week2.sort.Insertion;

public class MergeSort extends MergeBase {

    private final static int CUTOFF = 7;

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        if (a[mid+1].compareTo(a[mid]) > 0) {
            return;
        }

        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
