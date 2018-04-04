package AlgorithmsBook.week1.Assignment1_Percolation;

/*
 * Created by fnl-wl on 2017/11/18.
 * Site[i][j](i,j from 1 to n) map to WeightedQuickUnionUF's Array[(i-1)*n+j],and add two extral node Array[0] and Array[n^2+1] for top and bottom
 */
import  edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final WeightedQuickUnionUF judgeFull;
    private final int size;
    private boolean[][] opens;
    private int openSitesNumber;

    public Percolation(int n) {
        if (n < 1)throw new IllegalArgumentException("n should bigger than 0");
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(n*n+2);
        this.judgeFull = new WeightedQuickUnionUF(n*n+1);
        this.opens = new boolean[n][n];
        this.size = n;
        this.openSitesNumber = 0;
    }                // create n-by-n grid, with all sites blocked
    private int map2Dto1D(int row, int col) {
        return (row-1) * size + col;
    }
    private boolean validateSite(int row, int col) {
        return ((row > 0) && (row <= size)) && ((col > 0) && (col <= size));
    }
    public void open(int row, int col) {
        if (validateSite(row, col)) {
            if (!opens[row - 1][col - 1]) {
                opens[row - 1][col - 1] = true;
                openSitesNumber++;
                int location = map2Dto1D(row, col);
                if (row > 1 && opens[row - 2][col - 1]) { weightedQuickUnionUF.union(location - size, location);
                judgeFull.union(location - size, location); }
                if (row < size && opens[row][col - 1]) { weightedQuickUnionUF.union(location + size, location);
                judgeFull.union(location + size, location); }
                if (col > 1 && opens[row - 1][col - 2]) { weightedQuickUnionUF.union(location - 1, location);
                judgeFull.union(location - 1, location); }
                if (col < size && opens[row - 1][col]) { weightedQuickUnionUF.union(location + 1, location);
                judgeFull.union(location + 1, location); }
                if (row == 1) { weightedQuickUnionUF.union(0, location);
                judgeFull.union(0, location); }
                if (row == size) weightedQuickUnionUF.union(size * size + 1, location);
            }
        }
        else throw new IllegalArgumentException("row index and col index should from 1 to n");
    }   // open site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        if (validateSite(row, col)) {
            return opens[row - 1][col - 1];
        }
        else throw new IllegalArgumentException("row index and col index should from 1 to n");
    }  // is site (row, col) open?
    public boolean isFull(int row, int col) {
        if (validateSite(row, col)) {
            return judgeFull.connected(0, map2Dto1D(row, col));
        }
        else throw new IllegalArgumentException("row index and col index should from 1 to n");
    }  // is site (row, col) full?
    public int numberOfOpenSites() {
        return openSitesNumber;
    }       // number of open sites
    public boolean percolates() {
        return weightedQuickUnionUF.connected(0, size*size + 1);
    }              // does the system percolate?

    public static void main(String[] args) {
        // MethodDeclaration/Block[count(BlockStatement) = 0 and @containsComment = 'false']
    }

}
