package Interview.meituan.HowManyNumbers;

import java.util.Scanner;


public class Main {
    private static int coutDigits(int n) {
        int digits = 0;
        while (n != 0) {
            n /= 10;
            digits ++;
        }
        return digits;
    }
    private static int numbersOfDigits(int digits) {
        if (digits == 1) return 10;
        return 9*(int)Math.pow(10.0,(double) (digits-1));
    }
    private static int startOfDigits(int digits) {
        return (int)Math.pow(10.0,(double) (digits-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int res = 0;
            int n = sc.nextInt();
            if (n < 10)  res = n + 1;
            else {
                int digits = coutDigits(n);
                for (int i = 1;i < digits;++i) {
                    res += numbersOfDigits(i);
                }
                res += (n-startOfDigits(digits)+1)*digits;
            }
            System.out.println(n + " for " +res);
        }
    }
}
