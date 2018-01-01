package nao.cycledev.algorithms.part1.week1.home_work;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;
    private final int n;
    private final int t;
    private double[] experiments;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <=0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        this.t = trials;
        this.experiments = new double[t];

        for (int i = 0; i < t; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);

                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                }
            }

            experiments[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experiments);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experiments);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(t));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(t));
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(n, t);

        StdOut.printf("mean = %f\n", percolationStats.mean());
        StdOut.printf("stddev = %f\n", percolationStats.stddev());
        StdOut.printf("95 confidence interval = [%f, %f]",
                percolationStats.confidenceLo(), percolationStats.confidenceHi());
    }
}
