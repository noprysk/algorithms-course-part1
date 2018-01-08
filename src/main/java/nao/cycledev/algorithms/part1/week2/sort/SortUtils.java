package nao.cycledev.algorithms.part1.week2.sort;

public class SortUtils {

    public static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
