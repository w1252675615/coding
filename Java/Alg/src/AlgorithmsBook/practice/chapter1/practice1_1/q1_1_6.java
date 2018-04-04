package AlgorithmsBook.practice.chapter1.practice1_1;

/**
 * Created by fnl-wl on 2017/9/7.
 */
public class q1_1_6 {
    public static void main(String[] args){
        int f = 0;
        int g = 1;
        for(int i = 0;i <= 15;i++){
            System.out.println(f);
            f=f+g;
            g=f-g;
        }
    }
}
