package LeetCode.PalindromicSub;
/*
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Q647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] sChar = s.toCharArray();
        char[] exten = new char[2*s.length() +1];
        for(int i = 0; i < exten.length; ++i) {
            if((i&1) == 0) exten[i] = '#';
            else exten[i] = sChar[(i-1)/2];
        }
        int maxR = 0;
        int centre = -1;
        int[] pArr = new int[exten.length];
        int sum = 0;
        for(int i = 0; i < exten.length; ++i) {
            pArr[i] = i < maxR ? Math.min(maxR-i,pArr[2*centre-i]) : 1;
            while (i+pArr[i]<exten.length && i-pArr[i]>-1) {
                if (exten[i+pArr[i]] == exten[i-pArr[i]]) ++pArr[i];
                else break;
            }
            sum += pArr[i]/2;
            if (i+pArr[i] > maxR) {
                maxR = i + pArr[i];
                centre = i;
            }
        }
        return sum;
    }
}
