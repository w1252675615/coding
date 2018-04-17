package Offer.Q39_MoreThanHalfNumber;


public class MoreThanHalfNumber {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int result = array[0];
        int times = 1;
        for (int i = 1;i < array.length;++i) {
            if (times == 0) {
                result = array[i];
                ++times;
            }else if (array[i] == result) {
                ++ times;
            }else {
                -- times;
            }
        }
        int count = 0;
        for(int i = 0;i < array.length;++i) {
            if (array[i] == result) ++count;
        }
        if (2*count <= array.length) result = 0;
        return result;
    }

    public static void main(String[] args) {
        MoreThanHalfNumber moreThanHalfNumber = new MoreThanHalfNumber();
        int[] a = {2,2,2,2,2,1,3,4,5};
        System.out.println(moreThanHalfNumber.MoreThanHalfNum_Solution(a));
    }
}
