package Offer.Q38_StringPermutation;
/*
    求字符串的排列
 */
import java.util.ArrayList;
import java.util.Collections;

public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        char[] strArr = str.toCharArray();

        Permutation(strArr,0,res);
        Collections.sort(res);
        return res;
    }
    private void Permutation(char[] str,int start,ArrayList<String> res) {
        if (start == str.length - 1) {
            String s = String.valueOf(str);
            if(!res.contains(s)){
                res.add(s);
            }
            return;
        }
        for (int i = start;i < str.length;++i) { //注意=start是自己和自己交换
            swap(str,start,i);
            Permutation(str,start+1,res);
            swap(str,start,i);
        }
    }
    private void swap(char[] str,int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        ArrayList<String> res = stringPermutation.Permutation("ab");
        System.out.println(res);

    }
}
