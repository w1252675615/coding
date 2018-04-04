package offer.Q13_RobotMove;

public class RobotMove {
    public int movingCount(int threshold, int rows, int cols){
        if (threshold < 0 || rows < 1 || cols < 1) return 0;
        boolean[] visited = new boolean[rows*cols];
        return coreMove(threshold, rows, cols, 0, 0, visited);
    }
    private int coreMove(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row*cols+col] &&
                caculatesum(row)+caculatesum(col) <= threshold) {
            visited[row*cols+col] = true;
            count = 1+coreMove(threshold, rows, cols, row+1, col, visited) +
                    coreMove(threshold, rows, cols, row-1, col, visited) +
                    coreMove(threshold, rows, cols, row, col+1, visited) +
                    coreMove(threshold, rows, cols, row, col-1, visited);
        }
        return count;
    }

    private int caculatesum (int x) {
        int sum = 0;
        while (x > 0) {
            sum += x%10;
            x = x/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        robotMove.movingCount(5,3,3);
    }
}
