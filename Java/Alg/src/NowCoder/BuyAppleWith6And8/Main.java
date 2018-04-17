package NowCoder.BuyAppleWith6And8;
/*
	买n个苹果，1 <= n <= 100,可以6个1袋子，也可以8个一袋，要求袋数最少，买不了返回-1
 */

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
		int n = in.nextInt();
		System.out.println(getPackageNumber(n));
		}
}
private static int getPackageNumber(int n) {
		if ((n & 1) == 1 || n < 6)return -1;
		int num8 = n/8;
		int rest = n - 8*num8;
		while (num8 != 0 && rest%6 != 0) {
		--num8;
		rest +=8;
		}
		if (rest % 6 != 0) return -1;
		else return num8 + rest/6;
		}
}