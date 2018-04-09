package Offer.Q04_FindInPartiallySortedMatrix;

public class FindInPartiallySortedMatrix {
    boolean Find(int[][] matrix,int rows, int cols, int num) {
        if (matrix != null && matrix.length == rows) {
            for (int i = 0; i < rows; ++i) {
                if (matrix[i].length != cols) throw new IllegalArgumentException("Not a Matrix");
            }
        }else throw new IllegalArgumentException("Not a Matrix");
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == num) return true;
            if(matrix[row][col] > num) --col;
            else ++row;
        }
        return false;
    }

    public static void main(String[] args) {
        FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findInPartiallySortedMatrix.Find(matrix,4,4,5));

    }
}

