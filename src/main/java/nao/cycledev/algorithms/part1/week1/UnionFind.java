package nao.cycledev.algorithms.part1.week1;

import java.util.Arrays;

public class UnionFind {

  public int[] elements;
  public int count;

  public UnionFind(int n) {
    count = n;
    elements = new int[n];
    for (int i = 0; i < n ; i++) {
      elements[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  protected void union(int p, int q) {
  }

  protected int find(int p) {
    return 0;
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }
}
