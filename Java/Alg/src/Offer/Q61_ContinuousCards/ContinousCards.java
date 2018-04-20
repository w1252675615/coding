package Offer.Q61_ContinuousCards;

import java.util.Arrays;

/*
    判断数组中的数是否能构成一个顺子，A当做1，JQK分别是11,12，13，大小王是0可以当任何数
 */
public class ContinousCards {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 2) return false;
        Arrays.sort(numbers);
        int numberOfZeros  = 0;
        int numberOfGaps = 0;
        int start = 0;
        for (;start < numbers.length && numbers[start] == 0; ++ start) {
            numberOfZeros ++;
        }
        int end = start + 1;
        while (end < numbers.length) {
            if (numbers[start] == numbers[end]) return false;
            numberOfGaps += numbers[end] - numbers[start] -1;
            start = end++;
        }
        return numberOfGaps <= numberOfZeros;
    }
}
