package nao.cycledev.algorithms.part1.week2.sort;

// In iteration i, swap a[i] with each larger entry to its left.
// Move entries more than one position at a time by h-sorting the array.
// How to h-sort an array? Insertion sort, with stride length h.

public class Shellsort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N ; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (a[j].compareTo(a[j - h]) < 0) {
                        SortUtils.swap(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }

            h = h / 3;
        }
    }
}
