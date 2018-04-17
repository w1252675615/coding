package Offer.Q50_FirstNotRepeatingChar;
/*
    在数据流中找到第一个不重复的字符并返回位置
 */
import java.util.LinkedHashMap;

public class FirstNotRepeatingCharAndReturnPos {
    private LinkedHashMap<Character,Integer> chars = new LinkedHashMap<>();
    private int[] pos = new int[256];
    public int FirstNotRepeatingChar(String str) {
        int res = - 1;
        if (str == null || str.length() == 0) return  res;
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; ++i) {
            if (!chars.containsKey(strArr[i])){
                chars.put(strArr[i],1);
                pos[strArr[i]] = i;
            }else {
                chars.put(strArr[i],-1);
            }
        }
        for (char ch : chars.keySet()) {
            if (chars.get(ch) == 1) {
                res = pos[ch];
                break;
            }
        }
        return res;
    }
}
