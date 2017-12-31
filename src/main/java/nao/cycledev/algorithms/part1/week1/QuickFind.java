package nao.cycledev.algorithms.part1.week1;

public class QuickFind extends UnionFind {

  public QuickFind(int n) {
    super(n);
  }

  @Override
  public void union(int p, int q) {
    int pid = find(p);
    int qid = find(q);

    if (pid == qid) {
      return;
    }

    for (int i = 0; i < elements.length ; i++) {
      if (elements[i] == pid) {
        elements[i] = qid;
      }
    }
    count--;
  }

  @Override
  public int find(int p) {
    return elements[p];
  }
}
