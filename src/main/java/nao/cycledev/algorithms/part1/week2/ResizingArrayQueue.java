package nao.cycledev.algorithms.part1.week2;

import java.util.Arrays;

public class ResizingArrayQueue<T> {

    private int n = 0;
    private T[] array;
    private int head;
    private int tale;

    public ResizingArrayQueue(int defaultCapacity) {
        array = (T[]) new Object[defaultCapacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T item) {
        if (array.length == n) {
            resize(n * 2);
        }
        array[n++] = item;
    }

    public T pop() {
        T item = array[--n];
        array[n] = null;

        if ( n > 0 && n == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private void resize(int size){
        array = Arrays.copyOf(array, size);
    }
}
