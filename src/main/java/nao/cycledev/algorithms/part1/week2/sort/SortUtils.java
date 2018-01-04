package nao.cycledev.algorithms.part1.week2.sort;

public class SortUtils {

    public static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
