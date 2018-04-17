package Interview.Byte;

import java.util.HashMap;

public class TwoKindsMoney {
    public int getWayNumber (int[] money,int[] smoney, int sum) {
        if (money == null || smoney == null || (money.length==0&&smoney.length==0) ||sum <0)return 0;
        HashMap<Integer,Integer> smoneyUsed = new HashMap<>();
        int res = 0;
        for (Integer key :smoneyUsed.keySet()) {
            res += useMoney(money,key) * smoneyUsed.get(key);
            res %= 1e9 + 7;
        }
        return res;
    }
    private int useMoney(int[] money,int sum) {
        int[] dp = new int[sum+1];
        for (int j = 0;money[0]*j <= sum;++j) {
            dp[money[0]*j] = 1;
        }
        for (int i = 1;i<money.length;++i) {
            for (int j = 1;j <= sum;++j) {
                dp[j] += j - money[i] >= 0 ? dp[j - money[i]] : 0;
            }
        }
        return dp[sum];
    }
    private void useSMoney(int[] smoney,HashMap<Integer,Integer> res,int sum) {
       long n = 1 << smoney.length;
       for (long i = 0;i < n;++i) {
           int tempSum = 0;
           for (int j = 0;j<smoney.length;++j) {
               if ((i&(1<<j))!=0) {
                   tempSum += smoney[j];
               }
           }
           if (!res.containsKey(sum-tempSum)) {
               res.put(sum-tempSum,1);
           }else {
               int times = res.get(sum-tempSum);
               res.put(sum-tempSum,times+1);
           }

       }
    }
}
