package nao.cycledev.algorithms.part1.week2.home_work;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int count;
    private Node first;
    private Node last;

    public Deque() {}

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.prev = null;

        if (isEmpty()) {
            first.next = null;
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        count++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            last.prev = null;
            first = last;
        } else {
            last.prev = oldLast;
            oldLast.next = last;
        }
        count++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = first.item;
        first = first.next;
        first.prev = null;

        if (isEmpty()) {
            last = null;
        }

        count--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = last.item;
        last = last.prev;
        last.next = null;

        if (isEmpty()) {
            first = null;
        }

        count--;
        return item;
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
