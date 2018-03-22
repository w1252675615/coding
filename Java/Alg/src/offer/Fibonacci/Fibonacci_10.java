package offer.Fibonacci;

public class Fibonacci_10 {
    int fibonacci(int n, int n1, int n2) {
        if(n == 0) return n1;
        return fibonacci(n-1, n2, n1 + n2);
    }
    public int JumpFloorII(int target) {
        int base = 2;
        int result = 1;
        target -= 1;
        while (target > 0) {
            if ((target & 1) == 1) result = result*base;
            base = base*base;
            target >>= 1;
        }
        return result;
    }
}

/*
    def multi(a,b):
 5     c=[[0,0],[0,0]]
 6     for i in range(2):
 7         for j in range(2):
 8             for k in range(2):
 9                 c[i][j]=c[i][j]+a[i][k]*b[k][j]
10     return c
11
12
13 def matrix(n):
14     base=[[1,1],[1,0]]
15     ans=[[1,0],[0,1]]
16     while n:
17         if n&1:
18             ans=multi(ans,base)
19         base=multi(base,base)
20         n>>=1
21     # for i in range(2):
22     #     print(ans[i])
23     return ans[0][1]
 */
