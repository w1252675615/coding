package AlgorithmsBook.week3.Assignment3_Pattern_Recognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

public class BruteCollinearPoints {
    private Point[] sortedPoints;
    private ArrayList<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("points can't be null");
        int len = points.length;
        sortedPoints = new Point[len];
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("point[" + i +"] can't be null");
            sortedPoints[i] = points[i];
            for (int j = i; j > 0; j--) {
                if (sortedPoints[j].compareTo(sortedPoints[j-1]) < 0) {
                    Point temp = sortedPoints[j];
                    sortedPoints[j] = sortedPoints[j-1];
                    sortedPoints[j-1] = temp;
                } else if (sortedPoints[j].compareTo(sortedPoints[j-1]) == 0) throw new IllegalArgumentException("point[" + i +"] is a repeated point");
                else break;
            }
        }
        lineSegments = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int m = k + 1; m < len; m++) {
                        double baseline = sortedPoints[i].slopeTo(sortedPoints[j]);
                        if (baseline == sortedPoints[i].slopeTo(sortedPoints[k]) && baseline == sortedPoints[i].slopeTo(sortedPoints[m])) {
                            lineSegments.add(new LineSegment(sortedPoints[i], sortedPoints[m]));
                        }
                    }
                }
            }
        }
    }   // finds all line segments containing 4 points
    public int numberOfSegments() {
        return lineSegments.size();
    }       // the number of line segments
    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }               // the line segments

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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
