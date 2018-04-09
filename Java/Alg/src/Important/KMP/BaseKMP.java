package Important.KMP;

public class BaseKMP {
    public static int[] getNext(char[] patternArr) {//得到next数组
        if(patternArr.length <2) return new int[] {-1};
        int[] next = new int[patternArr.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;//当前需要判断的位置，next[i]得到的是i之前0~i-1的字符串的最长
        int cn = 0; //表示当前最长前缀的后一个位置
        while (pos < patternArr.length) {
            if (patternArr[cn] == patternArr[pos-1]){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else next[pos++] = 0;
        }
        return next;
    }
    public static int getIndexOf(String str, String pattern) {//返回第一个匹配成功的起始位置，没有返回-1
        if(str == null || pattern == null || pattern.length() < 1||str.length() < pattern.length()) return -1;
        char[] charArr = str.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int[] next = getNext(patternArr);
        int c = 0;
        int p = 0;
        while (c < charArr.length && p < patternArr.length) {
            if (charArr[c] == patternArr[p]) {
                ++c;
                ++p;
            }else if (next[p] == -1) {//退化到了模式串第一个位置
                ++c;
            }else{
                p = next[p];
            }
        }
        return p == patternArr.length ? c - p : -1;
    }
    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}
