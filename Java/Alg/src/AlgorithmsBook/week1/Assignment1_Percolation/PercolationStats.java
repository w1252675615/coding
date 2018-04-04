package AlgorithmsBook.week1.Assignment1_Percolation;

/*
 * Created by fnl-wl on 2017/11/20.
 *
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONSTANT_196 = 1.96;
    private final int trials;
    private final double mean;
    private final double stddev;
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1)throw new IllegalArgumentException("n and trials should bigger than 0");
        double[] openFraction = new double[trials];
        this.trials = trials;
        for (int i = 0; i < this.trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            }
            openFraction[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
        this.mean = StdStats.mean(openFraction);
        this.stddev = StdStats.stddev(openFraction);
    }    // perform trials independent experiments on an n-by-n grid
    public double mean() {
        return mean;
    }                          // sample mean of percolation threshold
    public double stddev() {
        return stddev;
    }                        // sample standard deviation of percolation threshold
    public double confidenceLo() {
        if (trials == 1) return Double.NaN;
        double z = CONSTANT_196 / Math.sqrt(trials);
        return mean - z * stddev;

    }                  // low  endpoint of 95% confidence interval
    public double confidenceHi() {
        if (trials == 1) return Double.NaN;
        double z = CONSTANT_196 / Math.sqrt(trials);
        return mean + z * stddev;
    }                  // high endpoint of 95% confidence interval

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats test = new PercolationStats(n, trials);
        test.mean();
    }
}
