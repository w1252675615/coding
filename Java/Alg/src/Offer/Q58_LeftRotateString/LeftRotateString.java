package Offer.Q58_LeftRotateString;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        String res = "";
        if (str == null || str.length() == 0 ) return res;
        char[] charArr = str.toCharArray();
        Reverse(charArr,0,n-1);
        Reverse(charArr,n,charArr.length-1);
        Reverse(charArr,0,charArr.length-1);
        res = String.valueOf(charArr);
        return res;
    }
    private void Reverse(char[] charArr,int start,int end) {
        if (start < 0 || end > charArr.length-1) return;
        while (start < end) {
            char temp;
            temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();
        String a = "abcdefg";
        System.out.println(leftRotateString.LeftRotateString(a,2));
    }
}
