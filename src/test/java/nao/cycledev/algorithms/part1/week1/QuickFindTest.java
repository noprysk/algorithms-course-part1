package nao.cycledev.algorithms.part1.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickFindTest {

  private int[] expected = {1, 1, 1, 8, 8, 1, 1, 1, 8, 8};

  @Test
  public void quickFind() {
    long start = System.currentTimeMillis();

    UnionFind qf = new QuickFind(10);

    qf.union(4, 3);
    qf.union(3, 8);
    qf.union(6, 5);
    qf.union(9, 4);
    qf.union(2, 1);
    qf.union(8, 9);
    qf.union(5, 0);
    qf.union(7, 2);
    qf.union(6, 1);

    assertTrue(qf.connected(5, 7));
    assertTrue(qf.connected(0, 5));
    assertFalse(qf.connected(0, 8));
    assertFalse(qf.connected(4, 5));

    assertEquals(2, qf.count);

    assertArrayEquals(expected, qf.elements);

    System.out.println(Arrays.toString(qf.elements));
    System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
  }
}
