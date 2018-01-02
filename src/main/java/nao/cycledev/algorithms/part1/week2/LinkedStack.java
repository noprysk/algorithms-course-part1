package nao.cycledev.algorithms.part1.week2;

public class LinkedStack<T> {

    private class Node {
        T item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }
}
