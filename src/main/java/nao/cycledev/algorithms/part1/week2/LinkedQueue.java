package nao.cycledev.algorithms.part1.week2;

public class LinkedQueue<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node first, last = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        return item;
    }
}
