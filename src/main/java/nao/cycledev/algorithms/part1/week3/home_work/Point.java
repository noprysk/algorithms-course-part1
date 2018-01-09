package nao.cycledev.algorithms.part1.week3.home_work;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        return 0;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        return 0;
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        return null;
    }
}
