package AlgorithmsBook.practice.chapter1.practice1_1;

/**
 * Created by fnl-wl on 2017/9/8.
 */
public class q1_1_11 {
    public static void main(String[] args){
        boolean[][] Args = new boolean[2][3];
        Args[1][0] = true;
        for(int i = 0;i < Args.length;i++)
            for(int j = 0;j <Args[i].length;j++)
                System.out.println(""+(i+1)+"行"+(j+1)+"列："+Args[i][j]);
    }
}
