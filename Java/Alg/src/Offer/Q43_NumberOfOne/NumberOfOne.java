package Offer.Q43_NumberOfOne;
/*
    1-n中1出现的次数
 */
public class NumberOfOne {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        char[] num = String.valueOf(n).toCharArray();
        return numberOfOne(num,0,num.length);
    }
    private int numberOfOne(char[] num, int start,int length) {
        int first = num[start] - '0';
        if (start == num.length-1 && first == 0) return 0;
        if (start == num.length-1 && first > 0) return 1;
        int numOfFirst = 0;
        int numOfOther = 0;
        int numOfRecursive = 0;
        if (first == 1) {
            numOfFirst = Integer.parseInt(String.copyValueOf(num,start+1,length-1))+1;
        }else if(first > 1) {
            numOfFirst = PowerOf10(length-1);
        }
        numOfOther = (first-1)*(length-1)*PowerOf10(length-2);
        numOfRecursive = numberOfOne(num,start+1,length-1);
        return numOfFirst+numOfOther+numOfRecursive;
    }
    private int PowerOf10(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int result = PowerOf10(n>>1);
        result *= result;
        if ((n&1) == 1) result *= 10;
        return result;
    }
}

