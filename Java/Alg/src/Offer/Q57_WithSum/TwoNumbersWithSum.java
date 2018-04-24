package Offer.Q57_WithSum;
/*
    输出和为s的两个数字，数组为递增排序
 */

import java.util.ArrayList;
import java.util.List;

public class TwoNumbersWithSum {
    List<List<Integer>> findNumbersWithSum(int[] array,int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (array == null || array.length < 2) return res;
        int small = 0;
        int big =  array.length - 1;
        while (small < big) {
            if (array[small] + array[big] < sum) {
                ++small;
            }else if (array[small] + array[big] > sum) {
                --big;
            }else {
                List<Integer> oneRes = new ArrayList<>();
                oneRes.add(small,big);
                res.add(oneRes);
                --big;
            }
        }
        return res;
    }
}
