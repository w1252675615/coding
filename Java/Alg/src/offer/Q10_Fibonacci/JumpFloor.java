package Offer.Q10_Fibonacci;
/*
    once can jump from 1 to n，result is 2^(n-1)
    n阶台阶，一次可以跳1到n的步数,结果是2^(n-1)
 */
public class JumpFloor {
    public int jumpFloor(int target) { //变态版跳青蛙
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
