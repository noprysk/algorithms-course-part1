package nao.cycledev.algorithms.part1.week1.home_work;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int openSites = 0;
    private final WeightedQuickUnionUF unionFind;
    private final int rowSize;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        grid = new boolean[n][n];
        rowSize = n;
        unionFind = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void open(int row, int col) {
        int i = row - 1;
        int j = col - 1;

        if (!isValidIndex(i, j)) {
            throw new IllegalArgumentException();
        }

        if (grid[i][j]) {
            return;
        }

        grid[i][j] = true;

        if (i == 0) {
            unionFind.union(toArrayIndex(i, j), 0);
        }

        if (i == rowSize - 1) {
            unionFind.union(toArrayIndex(i, j), rowSize * rowSize +1);
        }

        if ((i + 1) < rowSize) {
            if (grid[i + 1][j])
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i + 1, j));
        }

        if ((i - 1) >= 0) {
            if (grid[i - 1][j])
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i - 1, j));
        }

        if ((j + 1) < rowSize) {
            if (grid[i][j + 1])
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i, j + 1));
        }

        if ((j - 1) >= 0) {
            if (grid[i][j - 1])
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i, j - 1));
        }

        openSites++;
    }

    private int toArrayIndex(int i, int j) {
        return (i * rowSize) + j;
    }

    public boolean isOpen(int row, int col) {
        if (!isValidIndex(row - 1, col - 1)) {
            throw new IllegalArgumentException();
        }

        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (!isValidIndex(row - 1, col - 1)) {
            throw new IllegalArgumentException();
        }
        if (!isOpen(row, col)) {
            return false;
        }

        return unionFind.connected(0, toArrayIndex(row - 1, col - 1));
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return unionFind.connected(0, rowSize * rowSize + 1);
    }

    private boolean isValidIndex(int i, int j) {
        return i >= 0 && i < rowSize && j >= 0 && j < rowSize;
    }
}
