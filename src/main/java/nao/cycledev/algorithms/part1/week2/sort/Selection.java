package nao.cycledev.algorithms.part1.week2.sort;

// In iteration i, find index min of remaining entry.
// Swap a[i] and a[min].

public class Selection {

    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[min].compareTo(a[j]) == 1) {
                    min = j;
                }
            }

            SortUtils.swap(a, i, min);
        }
    }
}
