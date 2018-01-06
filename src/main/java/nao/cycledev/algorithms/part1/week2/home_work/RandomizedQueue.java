package nao.cycledev.algorithms.part1.week2.home_work;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int capacity = 1;
    private int n = 0;
    private Item[] queue;
    private int[] orderIndex;

    public RandomizedQueue() {
        queue = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (capacity < n + 1) {
            resizeQueue(2 * capacity);
        }

        queue[n++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(n);
        Item item = queue[index];
        queue[index] = queue[--n];
        queue[n] = null;

        if (n > 0 && n < capacity / 4) {
            resizeQueue(capacity / 2);
        }

        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return queue[StdRandom.uniform(n)];
    }

    public Iterator<Item> iterator() {
        orderIndex = new int[n];
        for (int i = 0; i < orderIndex.length ; i++) {
            orderIndex[i] = i;
        }

        StdRandom.shuffle(orderIndex);
        return new ListIterator();
    }

    private boolean arrayContains(int[] a, int el) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == el) {
                return true;
            }
        }

        return false;
    }

    private void resizeQueue(int capacity) {
        this.capacity = capacity;
        Item[] oldQueue = queue;

        queue = (Item[]) new Object[capacity];
        for (int i = 0; i < oldQueue.length ; i++) {
            if (oldQueue[i] != null) {
                queue[i] = oldQueue[i];
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    private class ListIterator implements Iterator<Item> {
        private int index;

        public boolean hasNext() {
            return index < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return queue[orderIndex[index++]];
        }
    }
}

