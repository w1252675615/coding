package offer.Q11_MinNumberInRotatedArray;

public class MinNumberInRotatedArray {
    private int minInArray(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (result > array[i]) result = array[i];
        }
        return result;
    }
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) throw new IllegalArgumentException();
        int index1 = 0;
        int index2 = array.length -1;
        int mid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }
            mid = index1 + (index2 - index1)/2;
            if (array[index1] == array[index2] && array[index1] == array[mid]) return minInArray(array,index1,index2);
            if (array[index1] <= array[mid]) index1 = mid;
            else index2 = mid;
        }
        return array[mid];
    }
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();
        int result = minNumberInRotatedArray.minNumberInRotateArray(a);
        System.out.println("result " + result);
    }
}


