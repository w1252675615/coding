package NowCoder.LongestCommonSubsequence;

public class LCS {
    public static int findLCS(String A, int n, String B, int m) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
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
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(findLCS("zynnqufc",8,"ddbauhkw",8));
    }
}
