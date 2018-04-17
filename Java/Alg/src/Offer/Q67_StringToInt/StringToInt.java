package Offer.Q67_StringToInt;
/*
    将字符串变为int，不能用库函数，注意多种异常情况
 */
public class StringToInt {
    public int StrToInt(String str) {
        int signed = 1;
        int start = 0;
        if (str == null || str.length() == 0) return 0;
        char[] strArr = str.toCharArray();
        if (strArr[start] == '+') {
            ++start;
        }else if (strArr[start] == '-'){
            ++start;
            signed = -1;
        }

        return (int)charToInt(strArr,start,signed);
    }
    public long charToInt(char[] strArr, int start,int signed) {
        int sum = 0;
        for (int i = start; i < strArr.length; ++i) {
            int num = strArr[i] - '0';
            if (num > 9 || num < 0) return 0;
            sum = 10*sum + signed*(num);
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        StringToInt stringToInt = new StringToInt();
        System.out.println(stringToInt.StrToInt("+123"));
    }
}
