package nao.cycledev.algorithms.part1.week2.home_work;

import java.util.Arrays;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int capacity = 1;
    private int n = 0;
    private Item[] queue;

    public RandomizedQueue() {
        queue = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (capacity < n + 1) {
            resizeQueue(2 * capacity);
        }

        queue[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        Item item = queue[--n];
        queue[n] = null;

        if (n > 0 && n == capacity / 4) {
            resizeQueue(capacity / 2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return null;
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
}

