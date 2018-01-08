package nao.cycledev.algorithms.part1.week2.home_work;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int capacity = 1;
    private int n = 0;
    private Item[] queue;

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
        return new ListIterator();
    }

    private void resizeQueue(int size) {
        this.capacity = size;
        Item[] oldQueue = queue;

        queue = (Item[]) new Object[capacity];
        for (int i = 0; i < oldQueue.length; i++) {
            if (oldQueue[i] != null) {
                queue[i] = oldQueue[i];
            }
        }
    }

    private class ListIterator implements Iterator<Item> {
        private int index;
        private final int[] orderIndex;

        public ListIterator() {
            orderIndex = new int[n];
            for (int i = 0; i < orderIndex.length; i++) {
                orderIndex[i] = i;
            }
            StdRandom.shuffle(orderIndex);
        }

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

