package Important.Manacher;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class BaseManacher {
    public static char[] manacherString(String str) { //在字符串间隔之间填充'#',包括开头结尾
        char[] charAtr = str.toCharArray();
        char[] res = new char[2* charAtr.length +1];
        for (int i = 0; i < res.length; ++i) {
            if ((i&1) == 0) res[i] = '#';
            else res[i] = charAtr[(i-1)/2];
        }
        return res;
    }
    public static int maxLpsLength(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] charAtr = manacherString(str);
        int[] pArr = new int[charAtr.length]; //pArr[i]表示以i为中心的回文半径大小（121是2）
        int centre = -1; //取得当前最大的回文半径的中心的下标
        int pR = -1; //当前最大回文串的长度（121是3）
        int max = Integer.MIN_VALUE;
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
            max = Math.max(max,pArr[i]);
        }
        return max-1; //得到的是扩充串的最大回文串的回文“半径”长度，减一刚好得到的原串的最大回文串的回文直径
    }
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLpsLength(str1));
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

    }
}
