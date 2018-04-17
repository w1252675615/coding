package Offer.Q56_NumbersApperOnce;
/*
    数组中除了两个数之外，所有的数都出现了两次，求这两个数
 */
public class NumbersApperOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) return;
        int num1XORnum2 = 0;
        int firstDigitDif = 0;
        for (int i = 0; i < array.length; ++i) {
            num1XORnum2 ^= array[i];
        }
        for (int i = 31; i > 0;--i) {
            if  (((num1XORnum2 >> i)& 1) == 1) {
                firstDigitDif = i;
                break;
            }
        }
        for (int i = 0; i < array.length; ++i) {
            if (((array[i]>>firstDigitDif) & 1) == 0) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    public static void main(String[] args) {
        NumbersApperOnce numbersApperOnce = new NumbersApperOnce();
        int[] num1 = {0};
        int[] num2 = {0};
        int[] array = {2,4,3,6,3,2,5,5};
        numbersApperOnce.FindNumsAppearOnce(array,num1,num2);
    }
}
