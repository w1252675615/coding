package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
    给定n，k，求出1-n中取k个数的组合结果
 */
public class Q77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        int start = (1 << k) - 1;
        int end = (1 << n) - (1 << (n-k));
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = start; i <= end; i = nextn(i)) {
            List<Integer> temp = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (((1 << j) & i) != 0) {
                    temp.add(j+1);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static int nextn(int k){
        int x = k & (-k);
        int t = k+x;
        return t | ((k^t)/x)>>2;
    }
}
