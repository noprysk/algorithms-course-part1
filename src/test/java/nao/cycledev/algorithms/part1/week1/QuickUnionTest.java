package nao.cycledev.algorithms.part1.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickUnionTest {

  @Test
  public void quickUnion() {
    long start = System.currentTimeMillis();

    UnionFind qu = new QuickUnion(10);

    qu.union(4, 3);
    qu.union(3, 8);
    qu.union(6, 5);
    qu.union(9, 4);
    qu.union(2, 1);
    qu.union(8, 9);
    qu.union(5, 0);
    qu.union(7, 2);
    qu.union(6, 1);

    assertTrue(qu.connected(5, 7));
    assertTrue(qu.connected(0, 5));
    assertFalse(qu.connected(0, 8));
    assertFalse(qu.connected(4, 5));

    assertEquals(2, qu.count);

    System.out.println(Arrays.toString(qu.elements));
    System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));
  }
}
