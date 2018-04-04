package offer.Q15_NumberOf1InBinary;

public class NumberOf1InBinary {
    int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count ++;
            n &= (n-1);
        }
        return count;
    }
}
