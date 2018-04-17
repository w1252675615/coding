package Offer.Q42_GreatsetSumOfSubarrays;

public class GreatsetSumOfSubarrays {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return Integer.MIN_VALUE;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i) {
            if (curSum <= 0) curSum = array[i];
            else curSum += array[i];
            if (curSum > greatestSum) greatestSum = curSum;
        }
        return greatestSum;
    }
}
