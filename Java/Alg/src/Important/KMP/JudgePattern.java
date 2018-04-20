package Important.KMP;
/*
    判断是否由重复字符串组成
 */
public class JudgePattern {
    public static int[] getNext(char[] patternArr) {//得到next数组
        if (patternArr.length < 2) return new int[]{-1};
        int[] next = new int[patternArr.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2; //当前计算位置
        int cn = 0; //当前前缀长度
        while(pos < next.length) {
            if (patternArr[cn] == patternArr[pos-1]) {
                next[pos++] = ++cn;
            }else if (cn > 0) {
                cn = next[cn];
            }else next[pos++] = 0;
        }
        return next;
    }
    public static boolean judge(String str) {
        char[] charArr = str.toCharArray();
        int[] next = getNext(charArr);
        int maxlen = next[next.length-1];
        return maxlen != 0 && (str.length()%(str.length()-maxlen) == 0);
    }

    public static void main(String[] args) {
        String a = "12312";
        System.out.println(judge(a));
    }
}
