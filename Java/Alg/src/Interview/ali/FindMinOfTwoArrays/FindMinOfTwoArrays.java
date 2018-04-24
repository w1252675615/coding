package Interview.ali.FindMinOfTwoArrays;

public class FindMinOfTwoArrays {
    static long FindMin(int[] from, int[] to) {
        return find(from,to,0,0,from.length);
    }
    static long find(int[] from, int[] to, int fIndex, int tIndex, int n) {

        if (n - fIndex >= 2) {
           return Math.max((long)(from[fIndex]*to[tIndex])+find(from,to,fIndex+1,tIndex+1,n),(long)(from[fIndex]*from[fIndex+1])+find(from,to,fIndex+2,tIndex,n));
       }
       else if(n - fIndex == 1) return (long)(from[fIndex]*to[tIndex])+find(from,to,fIndex+1,tIndex+1,n);
       else if(n - tIndex >= 2) return  (long)(to[tIndex]*to[tIndex+1])+find(from,to,fIndex,tIndex+2,n);
       else return 0L;

    }

    public static void main(String[] args) {
        int[] a = new int[]{9,9,9,9};
        int[] b = new int[]{1,2,3,4};
        long s = FindMin(a,b);
        System.out.println("result is " + s);
    }
}
