package chapter1.practice.practice1_1;

/**
 * Created by fnl-wl on 2017/9/13.
 */
public class q1_1_24 {
    public static int euclid(int p,int q){//p,q>0
        if(p < q){
            int t = q;
            q = p;
            p = t;
        }
        System.out.printf("p:%d q:%d\n",p,q);
        while(q!=0){
            int t = q;
            q = p%q;
            p = t;
            System.out.printf("p:%d q:%d\n",p,q);
        }
        return p;
    }
    public static void main(String[] args){
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println("Result is "+euclid(p,q));
    }
}
