package AlgorithmsBook.practice.chapter1.practice1_1;

/**
 * Created by fnl-wl on 2017/9/8.
 *将十进制的int转化为二进制的String
 */

public class q1_1_9 {
    public static void main(String[] args){
        int N = 6;
        String s ="";
        for(int n = N;n>0;n>>=1)
            s = n%2 + s;
        System.out.println(s);
    }
}
