package Offer.Q57_WithSum;

import java.util.ArrayList;
import java.util.List;

public class ContinuousSquenceWithSum {
    public static List<List<Integer>> findContinuousSequence(int[] array,int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length < 2) return res;
        int small = 0;
        int big = 1;
        int tempSum = array[small] + array[big];
        while (small < big && big < array.length) {
            if (array[small] + array[big] < sum) {
                tempSum += array[++big];
            }else if (array[small] + array[big] > sum) {
                ++small;
            }else {
                List<Integer> oneRes = new ArrayList<>();
                for (int i = small; i <= big; ++i) {
                    oneRes.add(array[i]);
                }
                res.add(oneRes);
                sum += array[++big];
            }
        }
        return res;
    }
}
