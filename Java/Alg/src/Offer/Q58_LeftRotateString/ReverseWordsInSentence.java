package Offer.Q58_LeftRotateString;

public class ReverseWordsInSentence {
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
    public String reverseSentence(String str) {
        String res = "";
        if (str == null || str.length() == 0) return res;
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = 0;
        while (start < charArr.length && end < charArr.length) {
            if (charArr[start] == ' ') {
                ++start;
                ++end;
            }else if (end < charArr.length-1 && charArr[end] != ' ') {
                ++end;
            }else {
                if(end == charArr.length-1) Reverse(charArr,start,end);
                else Reverse(charArr,start,end-1);
                start = ++end;
            }
        }
        Reverse(charArr,0,charArr.length-1);
        res = String.valueOf(charArr);
        return res;
    }

    public static void main(String[] args) {
        String a = "I'm Bob HA!";
        ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();
        System.out.println(reverseWordsInSentence.reverseSentence(a));
    }
}
