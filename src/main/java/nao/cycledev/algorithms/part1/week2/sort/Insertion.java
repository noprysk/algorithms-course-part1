package nao.cycledev.algorithms.part1.week2.sort;

// In iteration i, swap a[i] with each larger entry to its left.

public class Insertion {

    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    SortUtils.swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    SortUtils.swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
