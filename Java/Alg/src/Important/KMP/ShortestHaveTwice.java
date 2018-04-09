package Important.KMP;
/*
    给定一个字符串，在后面添加最少的字符串，使得新生成的字符串包含两个原字符串（起点不同），输出添加的字符串
 */
public class ShortestHaveTwice {
    public static int getNext(char[] patternArr) {//得到next数组
        int[] next = new int[patternArr.length+1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;//当前需要判断的位置，next[i]得到的是i之前0~i-1的字符串的最长
        int cn = 0; //表示当前最长前缀的后一个位置
        while (pos < patternArr.length+1) {
            if (patternArr[cn] == patternArr[pos-1]){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else next[pos++] = 0;
        }
        return next[next.length-1];
    }
    public static String shortesthaveTwice(String str) {//返回第一个匹配成功的起始位置，没有返回-1
        if(str == null || str.length() < 1) return null;
        char[] charArr = str.toCharArray();
        int next = getNext(charArr);
        int index = 0;
        char[] res = new char[str.length()-next];
        for (int i = 0;i < res.length;++i) {
            res[i] = charArr[next++];
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(shortesthaveTwice(test1));

        String test2 = "aa";
        System.out.println(shortesthaveTwice(test2));

        String test3 = "ab";
        System.out.println(shortesthaveTwice(test3));

        String test4 = "abcdabcd";
        System.out.println(shortesthaveTwice(test4));

        String test5 = "abracadabra";
        System.out.println(shortesthaveTwice(test5));

    }
}

