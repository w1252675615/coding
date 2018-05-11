package NowCoder.LongestCommonSubsequence;
/*
    返回第一个
 */
public class LCS2 {
    public String getlcs(String str1,String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return "";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = findLCS(str1,n,str2,m);
        char[] res = new char[dp[n-1][m-1]];
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        --n;
        --m;
        int index = res.length - 1;
        while (index > 0) {
            if (n > 0 && dp[n][m] == dp[n-1][m]) --n;
            else if (m > 0 && dp[n][m] == dp[n][m-1]) --m;
            else {
                res[index--] = arr1[n];
                --n;
                --m;
            }
        }
        return String.valueOf(res);
    }
    public int[][] findLCS(String A, int n, String B, int m) {
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int[][] dp = new int[n][m];
        dp[0][0] = arrA[0] == arrB[0] ? 1 : 0;
        for (int i = 1; i < n; ++i) dp[i][0] = Math.max(dp[i-1][0],arrA[i] == arrB[0] ? 1 : 0 );
        for (int i = 1; i < m; ++i) dp[0][i] = Math.max(dp[0][i-1],arrA[0] == arrB[i] ? 1 : 0 );
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (arrA[i] == arrB[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp;
    }
}
