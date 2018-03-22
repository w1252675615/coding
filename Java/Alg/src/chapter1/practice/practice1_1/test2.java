package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/11/16.
 */
public class test2 {
    static char x ='x';
    static int i = 10;

    public static void main(String[] args) {
        System.out.println(false?10:x);
        System.out.println(false?i:x);
        System.out.println(false?x:10);
        double s1 = Double.POSITIVE_INFINITY;
        double s2 = 0.0;
        if (s1 > s2) System.out.println("-1");;
    }
}
