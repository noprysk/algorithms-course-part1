package nao.cycledev.algorithms.part1.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionFind {

  private int[] elements;

  public UnionFind(int n) {
    fillElements(n);
  }

  public void union(int p, int q) {
    elements[q] = elements[p];
  }

  public boolean connected(int p, int q) {
    return elements[p] == elements[q];
  }

  private void fillElements(int n) {
    elements = new int[n];
    for (int i = 0; i < n ; i++) {
      elements[i] = i;
    }
  }

  public int getComponentsCount() {
    //Set<Integer> components = new HashSet<>(Arrays.asList(elements));
    return 0;//components.size();
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }
}
