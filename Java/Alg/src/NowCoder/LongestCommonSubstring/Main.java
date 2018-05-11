package NowCoder.LongestCommonSubstring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if (s1.length() > s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();
            int row = 0;
            int col = arr2.length-1;
            int max = 0;
            int end = 0;
            while (row < arr1.length) {
                int i = row;
                int j = col;
                int len = 0;
                while (i < arr1.length && j < arr2.length) {
                    if (arr1[i] != arr2[j]) len = 0;
                    else ++len;
                    if (len > max || (len == max && i < end)) {
                        max = len;
                        end = i;
                    }
                    ++i;
                    ++j;
                }
                if (col > 0) --col;
                else ++row;
            }
            System.out.println(s1.substring(end-max+1,end+1));
        }
    }
}
