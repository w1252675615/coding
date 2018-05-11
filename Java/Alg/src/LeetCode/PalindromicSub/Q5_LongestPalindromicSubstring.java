package LeetCode.PalindromicSub;
/*
    得到第一个最大回文子串
 */
public class Q5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] sChar = s.toCharArray();
        char[] exten = new char[2*s.length() +1];
        for(int i = 0; i < exten.length; ++i) {
            if((i&1) == 0) exten[i] = '#';
            else exten[i] = sChar[(i-1)/2];
        }
        int maxR = 0;
        int centre = -1;
        int maxpArr = 0;
        int indexMax = 0;
        int[] pArr = new int[exten.length];
        int sum = 0;
        for(int i = 0; i < exten.length; ++i) {
            pArr[i] = i < maxR ? Math.min(maxR-i,pArr[2*centre-i]) : 1;
            while (i+pArr[i]<exten.length && i-pArr[i]>-1) {
                if (exten[i+pArr[i]] == exten[i-pArr[i]]) ++pArr[i];
                else break;
            }
            if (i+pArr[i] > maxR) {
                maxR = i + pArr[i];
                centre = i;
            }
            if (pArr[i] > maxpArr) {
                maxpArr = pArr[i];
                indexMax = i;
            }
        }
        return s.substring((indexMax-maxpArr+1)/2,(indexMax-maxpArr+1)/2+maxpArr-1);
    }
}
