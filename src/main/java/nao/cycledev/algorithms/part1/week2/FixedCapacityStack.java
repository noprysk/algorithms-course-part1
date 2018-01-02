package nao.cycledev.algorithms.part1.week2;

import java.util.Arrays;

public class FixedCapacityStack<T> {

    private int n = 0;
    private T[] array;

    public FixedCapacityStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T item) {
        array[n++] = item;
    }

    public T pop() {
        T item = array[--n];
        array[n] = null;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
