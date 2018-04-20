package Offer.Q64_Accumulate;

import java.util.LinkedList;

/*

 */
public class Accumulate {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean judge = (n > 0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }

    public static void main(String[] args) {
        Accumulate accumulate = new Accumulate();
        System.out.println(accumulate.Sum_Solution(100));
    }
}
