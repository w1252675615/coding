package Offer.Q20_NumericStrings;


/*
    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     注意".12"和"12."也是
     核心是数值是小数/整数 （+"E/e" +整数）
 */
public class NumericStrings {
    static class Int {
        int value;
        Int (int value) {
            this.value = value;
        }
    }
    public boolean isNumeric(char[] str) {
        Int index = new  Int(0);
        boolean isNum = scanInteger(str,index);
        if(index.value < str.length && str[index.value] == '.') {
            ++index.value;
            isNum = scanUnsignedInteger(str,index) || isNum;
        }
        if(index.value < str.length && (str[index.value] == 'E'|| str[index.value] == 'e')) {
            ++index.value;
            isNum = scanInteger(str,index) && isNum;
        }
        return isNum && index.value == str.length;
    }
    private boolean scanUnsignedInteger(char[] str, Int index) {
        int start = index.value;
        while(index.value < str.length &&str[index.value] - 47 > 0 && 59 - str[index.value] > 0) ++index.value;
        return index.value - start > 0;
    }
    private boolean scanInteger(char[] str, Int index) { //开头
        if(index.value < str.length && (str[index.value] == '+' || str[index.value] == '-')) ++index.value;
        return scanUnsignedInteger(str,index);
    }

    public static void main(String[] args) {
        String a = "12e";
        char[] aa = a.toCharArray();
        NumericStrings numericStrings = new NumericStrings();
        System.out.println(numericStrings.isNumeric(aa));
    }
}
