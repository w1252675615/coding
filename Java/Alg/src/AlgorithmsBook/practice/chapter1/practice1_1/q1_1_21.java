package AlgorithmsBook.practice.chapter1.practice1_1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by fnl-wl on 2017/9/12.
 */
public class q1_1_21 {
    public static void main(String[] args){
        int linenumber = 1;
        try{
            InputStream is = q1_1_21.class.getResourceAsStream("q21.txt");
            //FileReader reader = new FileReader();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line," ");
                String name = null;
                int a,b;
                if(st.countTokens()==3){
                    name = st.nextToken();
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    System.out.printf("Name: %s A:%d B:%d A/B:%.3f",name,a,b,(double)a/b);

                }
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Wrong input at line: "+linenumber);
            e.printStackTrace();
        }
    }

}
