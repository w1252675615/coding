package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/9/11.
 */
public class q1_1_19 {
    static long[] Data = new long[1000];
    public static long F(int N){
        Data[0] = 0;
        Data[1] = 1;
        if(N==0 || Data[N]!=0) return Data[N];
        return Data[N]=F(N-1) + F(N-2);
    }
    public static void main(String[] args){
        for(int N=0;N<100;N++){
            System.out.println(N+":"+F(N));
        }
    }
}
