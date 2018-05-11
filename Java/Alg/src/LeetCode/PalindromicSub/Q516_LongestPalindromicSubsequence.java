package LeetCode.PalindromicSub;
/*
    最长子序列的长度
 */
public class Q516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] strArr = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; ++i) {  //求解长度为i+1的子串的所有dp结果
            for (int j = 0; j+i < n; ++j) {
                if (strArr[j] == strArr[j+i]) {
                    dp[j][j+i] = dp[j+1][j+i-1]+2; //特别的，当长度为2时，如dp[0][1] = dp[1][0] + 2;刚好满足
                }else {
                    dp[j][j+i] = Math.max(dp[j+1][j+i],dp[j][j+i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
