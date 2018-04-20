package Offer.Q56_NumbersApperOnce;
/*
    数组中只有一个数出现一次，其他的数都出现了三次，求出现一次的数
 */
public class NumberApperOnce {
    public int findNumberApperOnce(int[] numbers) {
        int res = Integer.MIN_VALUE;
        if (numbers == null || numbers.length < 4) return res;
        int[] times = new int[32]; //每一位1出现次数
        for (int i = 0; i < numbers.length;++i) {
            for (int j = 0; j < 32; ++j) {
                if (((numbers[i] >> j) & 1) == 1) ++times[j];
            }
        }
        res = 0;
        for (int i = 0;i < 32;++i) {
            if (times[i]%3 != 0) {
                res += (1<<i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberApperOnce numberApperOnce = new NumberApperOnce();
        int[] a = {-1,3,3,3,5,5,5};
        System.out.println(numberApperOnce.findNumberApperOnce(a));
    }
}
