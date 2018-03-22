package chapter1.practice.practice1_1;

//import edu.princeton.cs.algs4.In;
/**
 * Created by fnl-wl on 2017/9/6.
 */
public class test {
    public static int mystery(int a,int b){
        if(b == 0) return 1;
        if(b %2 ==0) return mystery(a*a,b/2);
        return mystery(a*a,b/2)*a;
    }
    public static void main(String[] args){
        //System.out.println(mystery(2,25));
        //System.out.println(mystery(3,11));
        int a= 50;
        char b = 60;
        if (a < b) System.out.println("a小于b");
    }
}
