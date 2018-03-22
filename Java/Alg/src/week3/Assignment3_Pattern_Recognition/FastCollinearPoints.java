package week3.Assignment3_Pattern_Recognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lineSegments;
    private Point[] sortedPoints;  // make the array as member variable run faster

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("points can't be null");
        int len = points.length;
        sortedPoints = new Point[len];
        for (int i = 0; i < len; ++i) {  // copy the array at the same time check and sort it in natural ordering use inserting sort
            if (points[i] == null) throw new IllegalArgumentException("point[" + i +"] can't be null");
            sortedPoints[i] = points[i];
            for (int j = i; j > 0; --j) {
                if (sortedPoints[j].compareTo(sortedPoints[j-1]) < 0) {
                    Point temp = sortedPoints[j];
                    sortedPoints[j] = sortedPoints[j-1];
                    sortedPoints[j-1] = temp;
                } else if (sortedPoints[j].compareTo(sortedPoints[j-1]) == 0) throw new IllegalArgumentException("point[" + i +"] is a repeated point");
                else break;
            }

        }

        lineSegments = new ArrayList<>();

        int start;
        int end;
        double tempSlope;
        for (int i = 0; i < len - 2; ++i) {
            Point srcPoint = sortedPoints[i];
            Point[] pointsAfter = new Point[len - i - 1];
            Point[] pointsBefore = new Point[i];
            System.arraycopy(sortedPoints, 0, pointsBefore, 0, i);
            System.arraycopy(sortedPoints, i + 1, pointsAfter, 0, len - i - 1);
            Arrays.sort(pointsBefore, srcPoint.slopeOrder()); // array use for checking whether is subsegment
            Arrays.sort(pointsAfter, srcPoint.slopeOrder()); // array use for finding the endPoint which can form 4-point collinear with srcPoint
            start = 0;
            end = 1;
            tempSlope = srcPoint.slopeTo(pointsAfter[start]);
            while (end <= len - i - 1) {     // "=" means that we check for the last point of pointsAfter
                if (end == len - i - 1 || srcPoint.slopeTo(pointsAfter[end]) != tempSlope) { // avoid NullPointerException put "end == len - i - 1" on the left
                    if (end - start >= 3 && !isSubsegment(pointsBefore, srcPoint, tempSlope)) {
                        lineSegments.add(new LineSegment(srcPoint, pointsAfter[end - 1]));
                    }
                    if (end < len - i -3) { // no enough points to form 4 points, break in advance
                        start = end;
                        end = start + 1;
                        tempSlope = srcPoint.slopeTo(pointsAfter[start]);
                    } else break;
                } else  end++; // means "srcPoint.slopeTo(pointsAfter[end]) == tempSlope"
            }
        }
    }    // finds all line segments containing 4 or more points
    public int numberOfSegments() {
        return lineSegments.size();
    }       // the number of line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }               // the line segments
    private boolean isSubsegment(Point[] pointsbefore, Point srcpoint, double currentslope) { // use binary search
        int lo = 0;
        int hi = pointsbefore.length - 1;
        while (lo <= hi) {
            int mid = lo +(hi - lo) / 2;
            if (srcpoint.slopeTo(pointsbefore[mid]) < currentslope) lo = mid + 1;
            else if (srcpoint.slopeTo(pointsbefore[mid]) > currentslope) hi = mid -1;
            else return true;
        }
        return false;
    }
    /* private void sort(Point[] points, int start, int end, Comparator<Point> comparator) {
        for (int i = start; i < end; i++)
            for (int j = i; j > start && less(comparator, points[j], points[j-1]); j--)
                exch(points, j, j-1);
    }
    private boolean less(Comparator  c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }
    private void exch(Point[] a, int i, int j) {
        Point swap = a[i];
        a[i] = a[j];
        a[j] = swap;
          }*/
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
            StdOut.println(p);
        }
        StdDraw.show();

        // print and draw the line segments
        points[2] = null;
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}