package NowCoder.LongestCommonSubstring;

public class LongestSubstring {
    public int findLongest(String A, int n, String B, int m) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int row = 0;
        int col = m-1;
        int max = 0;
        while (row < n) {
            int i = row;
            int j = col;
            int len = 0;
            while (i < n && j < m) {
                if (arrA[i] != arrB[j]) len = 0;
                else ++len;
                if (len > max) max = len;
                ++i;
                ++j;
            }
            if (col > 0) --col;
            else ++row;
        }
        return max;
    }
}
