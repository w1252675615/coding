package Interview.meituan.GcdAndWhat;
/*
    奇怪的题目
 */
import java.util.Scanner;


public class Main {
    private static int Gcd(int[][] res,int n ,int m) {
        int t;
        int i = n;
        int j = m;
        while ((t=i%j) != 0) {
            i = j;
            j = t;
        }
        res[n][m] = j;
        return j;
    }
    public static void main(String[] args) {
        int MAX = 100001;
        int[][] phi = new int[MAX][MAX];

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[] A = new int[N+1];
            A[1] = p;
            int sum = 0;
            for (int i = 2; i < A.length;++i) {
                A[i] = (A[i]+153)%p;
            }
            for (int i = 1; i <= n;++i) {
                for (int j = 1; j <= m;++j) {
                    if (i >= j) {
                        if (phi[i][j] != 0) sum += phi[i][j];
                        else sum += Gcd(phi,i,j);
                    }else {
                        if (phi[j][i] != 0) sum += phi[j][i];
                        else sum += Gcd(phi,j,i);
                    }

                }
            }
            System.out.println(sum);
        }
    }
}