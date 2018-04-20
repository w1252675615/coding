package Offer.Q49_UglyNumber;

public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        int numberToMultiply2 = 0;
        int numberToMultiply3 = 0;
        int numberToMultiply5 = 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        while (nextUglyIndex < index) {
            int min = min(uglyNumbers[numberToMultiply2]*2,uglyNumbers[numberToMultiply3]*3,uglyNumbers[numberToMultiply5]*5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[numberToMultiply2]*2 <= min) numberToMultiply2++;
            while (uglyNumbers[numberToMultiply3]*3 <= min) numberToMultiply3++;
            while (uglyNumbers[numberToMultiply5]*5 <= min) numberToMultiply5++;
            nextUglyIndex++;
        }
        return uglyNumbers[index-1];
    }
    private int min(int num1, int num2, int num3) {
        int min = num1 < num2 ?  num1 : num2;
        return min < num3 ? min : num3;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.GetUglyNumber_Solution(2));
    }
}
