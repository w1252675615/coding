package AlgorithmsBook.practice.chapter1.practice1_1;

/**
 * Created by fnl-wl on 2017/9/11.
 */
public class q1_1_20 {
    static double[] Data = new double[1000];
    public static double Factorial_ln(int N){
        Data[0] = 0;
        if(N-1==0 || Data[N-1]!=0) return Data[N-1];
        return Data[N-1] = Factorial_ln(N-1) + Math.log(N);
    }
    public static void main(String[] args){
        for(int N=1;N<101;N++){
            System.out.printf("ln(%d!)=%f\n",N,Factorial_ln(N));
        }
    }
}
