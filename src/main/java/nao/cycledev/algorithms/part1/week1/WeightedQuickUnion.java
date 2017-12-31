package nao.cycledev.algorithms.part1.week1;

import java.util.Arrays;

public class WeightedQuickUnion extends UnionFind {

  public int[] sz;

  public WeightedQuickUnion(int n) {
    super(n);

    sz = new int[n];
    Arrays.fill(sz, 1);
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) return;

    if (sz[pRoot] > sz[qRoot]) {
      elements[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    } else {
      elements[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    }
    count--;
  }

  @Override
  public int find(int p) {

    while(p != elements[p]) {
      p = elements[p];
    }

    return p;
  }
}
