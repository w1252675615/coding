package offer.Q14_CuttingRope;
/*
    长度为n的绳子剪成若干段(大于一段)，每段为整数，要求所有段长度的乘积最大，求最大值
 */
public class CuttingRope {
    public static int cutRope(int length) { //贪婪算法
        if (length < 2) return length;
        if (length == 2) return 1;
        int timesOf3,timesOf2;
        timesOf3 = length/3;
        if (length - timesOf3*3 == 1) timesOf3 -= 1;
        timesOf2 = (length - timesOf3*3)/2;
        return (int)(Math.pow(3.0,(double)timesOf3)*Math.pow(2.0,(double)timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(cutRope(9));
    }
}
