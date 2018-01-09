package nao.cycledev.algorithms.part1.week3;

public class MergeBase {

    protected static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
