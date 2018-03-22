package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/9/12.
 */
public class q1_1_22 {
    public static int deep = -1;
    public static int rank (int key, int[] a){
        return rank(key,a,0,a.length-1);
    }
    public static int rank(int key, int[] a,int lo,int hi){
        if(lo>hi) return  -1;
        deep++;
        for(int i = 0;i<deep;i++){
            System.out.print("  ");
        }
        System.out.printf("lo:%d hi:%d\n",lo,hi);
        int mid = (lo+hi)/2;
        if(key<a[mid]) return rank(key,a,lo,mid-1);
        else if(key>a[mid]) return rank(key,a,mid+1,hi);
        else return mid;
    }
    public static void main(String[] args){
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int key = 2;
        System.out.println("result:"+rank(key,a));
    }
}
