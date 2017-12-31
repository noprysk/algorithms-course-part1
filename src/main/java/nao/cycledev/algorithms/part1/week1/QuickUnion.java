package nao.cycledev.algorithms.part1.week1;

public class QuickUnion extends UnionFind {

  public QuickUnion(int n) {
    super(n);
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) return;

    elements[pRoot] = qRoot;
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
