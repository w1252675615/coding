package Important;

import java.io.UnsupportedEncodingException;
import java.util.*;

class test {
    private test(){};
    private static class singletonHolder {
        private static final test instance = new test();
    }
    public static test getInstance() {
        return singletonHolder.instance;
    }

    public static void main(String[] args) {
        LinkedList a ;
        ArrayDeque b;
        /*String s = "123";
        try {
            byte[] b = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }*/
        System.out.println(3%5);
    }
}