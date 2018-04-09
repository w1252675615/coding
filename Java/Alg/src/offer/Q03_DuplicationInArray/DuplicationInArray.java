package Offer.Q03_DuplicationInArray;

/*
    长度为n的数组，其中数字取值0 - n-1， 请找出任意一个重复的数字
    修改数组的方法
    n刚好够所有数字无重复的重复一遍
 */

public class DuplicationInArray {
    private int duplicatedNumber;
    public boolean findDuplicatedNumber(int[] array, int length) {
        if (array == null || length <= 0) throw new IllegalArgumentException("Wrong Arguments");
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 || array[i] > length -1) throw new IllegalArgumentException("Wrong Numbers in Array");
        }
        for (int i = 0; i < length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    duplicatedNumber = array[i];
                    return true;
                }
                //swap
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicationInArray duplicationInArray = new DuplicationInArray();
        int[] array = {2,3,1,0,2,5,3};
        if(duplicationInArray.findDuplicatedNumber(array,array.length)) System.out.println("find duplicated number is "+ duplicationInArray.duplicatedNumber);
    }
}
