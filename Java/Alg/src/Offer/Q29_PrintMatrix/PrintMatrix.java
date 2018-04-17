package Offer.Q29_PrintMatrix;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<>(rows*columns);
        while (rows > 2*start && columns > 2*start) {
            printCircle(matrix,columns,rows,start,result);
            ++start;
        }
        return result;
    }
    private void printCircle(int[][] matrix,int columns, int rows, int start, ArrayList<Integer> result) {
        int endX = columns - start -1;
        int endY = rows - start - 1;
        for (int i = start;i <= endX;++i) {
            result.add(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start+1; i <= endY;++i) {
                result.add(matrix[i][endX]);
            }
        }
        if (start < endY && start < endX) {
            for (int i = endX-1;i >= start;--i) {
                result.add(matrix[endY][i]);
            }
            for (int i = endY-1;i >= start+1;--i) {
                result.add(matrix[i][start]);
            }
        }
    }
}
