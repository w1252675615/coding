package Important.GCD;
/*
    扩展欧几里得算法，已知ax+by=g（g=gcd（a，b）），求g的同时求b
    ax + by = g       //g=gcd(a,b)
==> bx’ + (a%b)y’ = g
==> bx’ + (a-a/b*b)y’ = g
==> ay’ + b(x’-a/b*y’) = g
==> x=y’、y=x’-a/b*y’ //迭代式
 */
public class ExGcd {
    public static int exGcd(int a, int b, int[] x, int[] y) {
        if(b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        int[] xx ={0};
        int[] yy ={0};
        int g = exGcd(b,a%b,xx,yy);
        x[0] = yy[0];                  //xx 和 yy存的是本次递归x'和y'的值，求出x，y后，返回上一次调用时，
        y[0] = xx[0]-(a/b)*yy[0];      //x，y刷新上一次的xx和yy，同时根据递推式求出上一次的x，y
        return g;                      //到最外层函数，求出的是最后的x，y
    }

    public static void main(String[] args) {
        int[] x = {0};
        int[] y = {0};
        exGcd(6,2,x,y);
        System.out.println(x[0]);
        System.out.println(y[0]);
    }
}
