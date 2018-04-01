package offer.Q17_Print1ToMaxOfDigits;
/*
    print number of n digits,from 1 to max
    打印从1到最大的n位数
 */

public class Print1ToMaxOfDigits_017 {
    private void PrintNumber (char[] number) {
        boolean isBeginning0 = true;
        for (int i =0;i < number.length;++i) {
            if (isBeginning0 && number[i] != '0') isBeginning0 = false;
            if (!isBeginning0) System.out.print(number[i]);
        }
        System.out.println();
    }
    private void corePrint1ToMaxOfDigits(char[] number, int length, int index) {
        if (index == length) {
            PrintNumber(number);
            return;
        }
        for (int i = 0;i < 10;++i) {
            number[index] = (char)(48+i);
            corePrint1ToMaxOfDigits(number,length,index+1);
        }
    }
    public void Print1ToMaxOfDigits(int n) {
        if (n <= 0) throw new IllegalArgumentException("n should bigger than 0");
        char[] number = new char[n];
        corePrint1ToMaxOfDigits(number,n,0);
    }

    public static void main(String[] args) {
        Print1ToMaxOfDigits_017 print1ToMaxOfDigits_017 = new Print1ToMaxOfDigits_017();
        print1ToMaxOfDigits_017.Print1ToMaxOfDigits(3);
    }

}
