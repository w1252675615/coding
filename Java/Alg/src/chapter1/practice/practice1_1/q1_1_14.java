package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/9/8.
 */
public class q1_1_14 {
    public static int lg(int x){
        if(x<=0)return -1;
        int i = 0;
        while(x>1){
            x>>=1;
            i++;
        }
        return i;
    }
    public static void main(String[] args){
        int a = 1;
        System.out.println(lg(a));
    }
}
