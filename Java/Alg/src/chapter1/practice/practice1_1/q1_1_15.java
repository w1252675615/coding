package chapter1.practice.practice1_1;

import java.util.Arrays;

/**
 * Created by fnl-wl on 2017/9/9.
 */
public class q1_1_15 {
    public static int[] histogram(int[] a,int M){  // M>0
        int[] Re = new int[M];
        Arrays.sort(a);
        if(a[a.length-1]<0) Re = null;
        else{
            int n = 0;
            while (a[n] < 0) {
                n++;
            }
            for (int i = n; i < a.length; i++) {
                Re[a[i]]++;
            }
        }
        return Re;
    }
    public static void main(String[] args){
        int[] a = {9,8,8,7,6,5,4,3,2,1,0};
        int M = 10;
        int[] b;
        b = histogram(a,M);
        for(int i = 0;i < b.length;i++) {
            System.out.println(b[i]);
        }
    }
}
