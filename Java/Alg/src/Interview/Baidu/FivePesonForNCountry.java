package Interview.Baidu;
/*
    n个国家，每个国家5名队员，站成一行，要求每个队员有要和自己国家的队员在一起，有多少种站法
 */
public class FivePesonForNCountry {
    static int[][] npk = new int[30][30];
    static int[] factor = new int[100];
    static int MOD = 1000000007;
    private static int biggerNumWithSameDigits(int num) {
        int a = num & (-num);
        int b = num + a;
        return b | ((num^b)/a) >> 2;
    }
    private static int nPickK(int n, int k) {
        if (n < k || n < 0) return -1;
        if (k == 0 || k == n) return 1;
        if (k > n/2) k = n-k;
        int start = (1 << k) - 1;
        int end = (1 << n) - (1 << (n-k));
        int res = 0;
        for (int i = start; i <= end; i = biggerNumWithSameDigits(i)) {
            ++res;
        }
        return res;
    }
    private static int factorial(int n) {
        if (factor[n] != 0) return factor[n];
        if (n == 0 || n == 1) {
            factor[n] = 1;
            return 1;
        }else {
            factor[n] = n * factorial(n-1);
            return factor[n];
        }
    }
    private static long countWayforTwo(int n) {
        long sum = 0;
        for (int i = 0; i <= n; ++i) {
            int signed = (i & 1) == 1 ? -1 : 1;
            sum += nPickK(n,i)*signed*factorial(2*n-i)%MOD;
        }
        return sum%MOD;
    }

    private static long powerWithUnsignedInt(int base,  int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        long result = powerWithUnsignedInt(base,exponent>>1);
        result *= result;
        if((exponent & 1)==1) result *= base;
        return result;
    }
    public static void main(String[] args) {
        int factor5 = factorial(5);
        for (int i = 1; i < 5; ++i) {
            long a = powerWithUnsignedInt(factor5,i)%MOD;
            long b = countWayforTwo(i)%MOD;
            long res = (a*b)%MOD;
            System.out.println("input:"+i+"output:"+res);
        }

    }
}
