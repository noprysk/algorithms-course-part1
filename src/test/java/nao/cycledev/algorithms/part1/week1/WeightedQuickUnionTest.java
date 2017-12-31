package nao.cycledev.algorithms.part1.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WeightedQuickUnionTest {

  @Test
  public void weightedQuickUnion() {
    long start = System.currentTimeMillis();

    UnionFind wqu = new WeightedQuickUnion(10);

    wqu.union(4, 3);
    wqu.union(3, 8);
    wqu.union(6, 5);
    wqu.union(9, 4);
    wqu.union(2, 1);
    wqu.union(8, 9);
    wqu.union(5, 0);
    wqu.union(7, 2);
    wqu.union(6, 1);

    assertTrue(wqu.connected(5, 7));
    assertTrue(wqu.connected(0, 5));
    assertFalse(wqu.connected(0, 8));
    assertFalse(wqu.connected(4, 5));

    assertEquals(2, wqu.count);

    System.out.println(Arrays.toString(wqu.elements));
    System.out.println("Duration (ms): " + (System.currentTimeMillis() - start));

  }
}
