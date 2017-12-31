package nao.cycledev.algorithms.part1.week1.home_work;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int BLOCKED = 0;
    private final int OPEN = 1;
    private int[][] grid;
    private int openSites = 0;
    private WeightedQuickUnionUF unionFind;
    private int rowSize;

    public Percolation(int n) {
        grid = new int[n][n];
        rowSize = n;
        unionFind = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = BLOCKED;
            }
        }
    }

    public void open(int row, int col) {
        int i = row - 1;
        int j = col - 1;

        if (!isValidIndex(i, j)) {
            throw new IllegalArgumentException();
        }

        grid[i][j] = OPEN;

        if (i == 0) {
            unionFind.union(0, toArrayIndex(i, j));
        }

        if (i == rowSize - 1) {
            unionFind.union((rowSize * rowSize) + 1, toArrayIndex(i, j));
        }

        if ((i + 1) < rowSize) {
            if (grid[i + 1][j] == OPEN)
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i + 1, j));
        }

        if ((i - 1) >= 0) {
            if (grid[i - 1][j] == OPEN)
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i - 1, j));
        }

        if ((j + 1) < rowSize) {
            if (grid[i][j + 1] == OPEN)
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i, j + 1));
        }

        if ((j - 1) >= 0) {
            if (grid[i][j - 1] == OPEN)
                unionFind.union(toArrayIndex(i, j), toArrayIndex(i, j - 1));
        }

        openSites++;
    }

    private int toArrayIndex(int i, int j) {
        return (i * rowSize) + j;
    }

    public boolean isOpen(int row, int col) {
        if (!isValidIndex(row - 1, col - 1)) {
            throw new IllegalArgumentException("row = " + row + "or col= " + col + " is invalid.");
        }

        return grid[row - 1][col - 1] == OPEN;
    }

    public boolean isFull(int row, int col) {
        return unionFind.connected(toArrayIndex(row - 1, col - 1), 0 );
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return unionFind.connected(0, rowSize * rowSize + 1 );
    }

    private boolean isValidIndex(int i, int j) {
        return i >= 0 && i < rowSize && j >= 0 && j < rowSize;
    }
}
