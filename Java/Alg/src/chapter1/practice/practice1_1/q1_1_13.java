package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/9/8.
 * 将M矩阵转置为T矩阵并输出
 */
public class q1_1_13 {
    public static void main(String[] args){
        int[][] M = {{1,2,3},{4,5,6}};
        int[][] T = new int[M[0].length][M.length];
        for(int j = 0;j < M[0].length;j++,System.out.println("\n"))
            for(int i = 0;i < M.length;i++,System.out.print(" "))
            {
                T[j][i] = M[i][j];
                System.out.print(T[j][i]);
            }
    }
}
