package nao.cycledev.algorithms.part1.week1;

import java.util.Arrays;

public class QuickFind {

  private int[] elements;

  public QuickFind(int n) {

    elements = new int[n];
    UFUtils.fillElements(elements, n);
  }

  public void union(int p, int q) {
    int pid = elements[p];
    int qid = elements[q];

    for (int i = 0; i < elements.length ; i++) {
      if (elements[i] == pid) {
        elements[i] = qid;
      }
    }
  }

  public boolean connected(int p, int q) {
    return elements[p] == elements[q];
  }

  public int[] getElements() {
    return elements;
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }
}
