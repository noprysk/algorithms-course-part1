package nao.cycledev.algorithms.part1.week2.home_work;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void test1(){

        int[] expected = { 18, 2, 4, 5, 4, 7, 25 };
        int[] actual = new int[7];

        Deque<Integer> deque = new Deque<>();

        deque.addLast(5);
        deque.addFirst(4);
        deque.addFirst(2);
        deque.addFirst(18);
        deque.addLast(4);
        deque.addLast(7);
        deque.addLast(25);

        Iterator<Integer> iterator = deque.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            actual[i++] = iterator.next();
        }

        assertEquals(7, deque.size());
        assertArrayEquals(expected, actual);
    }


    @Test
    public void test2(){

        int[] expected = { 4, 4, 7 };
        int[] actual = new int[3];

        Deque<Integer> deque = new Deque<>();

        deque.addLast(5);
        deque.addFirst(4);
        deque.addFirst(2);
        deque.removeFirst();
        deque.removeLast();
        deque.addLast(4);
        deque.addLast(7);
        deque.addLast(25);
        deque.addFirst(25);
        deque.removeLast();
        deque.removeFirst();

        Iterator<Integer> iterator = deque.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            actual[i++] = iterator.next();
        }

        assertEquals(3, deque.size());
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {

        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        deque.addFirst(1);
        deque.removeFirst(); //    ==> 1
        deque.removeFirst();

        assertEquals(0, deque.size());
    }
}