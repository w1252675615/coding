package Important.Manacher;
/*
    在末尾添加足够短的字符串使得整个字符串成为回文串，并且字符串长度最短
 */
public class ShortestEnd {
    public static char[] manacherString(String str) { //在字符串间隔之间填充'#',包括开头结尾
        char[] charAtr = str.toCharArray();
        char[] res = new char[2* charAtr.length +1];
        for (int i = 0; i < res.length; ++i) {
            if ((i&1) == 0) res[i] = '#';
            else res[i] = charAtr[(i-1)/2];
        }
        return res;
    }
    public static String shortestEnd(String str) {
        if(str == null || str.length() == 0) return null;
        char[] charAtr = manacherString(str);
        int[] pArr = new int[charAtr.length]; //pArr[i]表示以i为中心的回文半径大小（121是2）
        int centre = -1; //取得当前最大的回文半径的中心的下标
        int pR = -1; //最大回文半径的右边界的下标（121是3）
        int maxPEnd = -1;//最大回文半径
        for (int i = 0;i < charAtr.length;++i) {
            pArr[i] = i < pR ? Math.min(pArr[2*centre- i],pR-i):1; //i超出最大回文右边界，从1开始扩。没超出，根据对称点的回文半径三种情况
            while (i-pArr[i] > -1 && i+pArr[i] < charAtr.length) {
                if (charAtr[i+pArr[i]] == charAtr[i-pArr[i]]) ++pArr[i];
                else break;
            }
            if (i+pArr[i] > pR) {
                pR = i + pArr[i];
                centre = i;
            }
            if (charAtr.length == pR) {
                maxPEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length()-(maxPEnd-1)];
        for(int i =0;i<res.length;++i) {//记得maxPEnd是扩充串的最大回文串的回文“半径”长度，减一刚好得到的原串的最大回文串的回文直径
            res[res.length-1-i] = charAtr[2*i+1];
        }
        return String.valueOf(res);

    }
    public static void main(String[] args) {
        String str1 = "abc1234321";
        System.out.println(shortestEnd(str1));
    }
}
