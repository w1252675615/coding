package AlgorithmsBook.practice.chapter1.practice1_1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by fnl-wl on 2017/9/12.
 */
public class q1_1_23 {
    public static int rank(int key,int[] a){
        int lo = 0;
        int hi = a.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(key<a[mid])  hi = mid - 1;
            else if(key>a[mid])  lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args){
        boolean showNotInWhitelist = false;
        if(args[0].equals("+")) showNotInWhitelist = true;
        else if(args[0].equals("-")) showNotInWhitelist = false;
        else throw new IllegalArgumentException("+ or -");
        ArrayList<Integer> whiteList = new ArrayList<>(1000000);
        try{
            InputStream is = q1_1_21.class.getResourceAsStream("largeW.txt");
            //DataInputStream dis = new DataInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line = br.readLine())!=null){
                whiteList.add(Integer.parseInt(line.trim()));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Integer[] wL = wl.toArray(new Integer[wl.size()]);
        int[] whitelist = whiteList.stream().mapToInt(i->i).toArray();
        try{
            InputStream is = q1_1_21.class.getResourceAsStream("largeW.txt");
            //DataInputStream dis = new DataInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            int a = -1;
            while((line = br.readLine())!=null){
                if(rank(a=Integer.parseInt(line.trim()),whitelist)==-1) {if(showNotInWhitelist) System.out.println(a);}
                else if(!showNotInWhitelist) System.out.println(a);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
