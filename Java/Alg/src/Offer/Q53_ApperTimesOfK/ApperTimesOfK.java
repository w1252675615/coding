package Offer.Q53_ApperTimesOfK;
/*
    排序数组中K出现的次数
 */
public class ApperTimesOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length < 1) return 0;
        int start = getFirstK(array,0,array.length-1,k);
        int end = getLastK(array,0,array.length-1,k);
        int res = 0;
        if (start != -1 && end != -1) {
            res = end - start + 1;
        }
        return res;
    }
    private static int getFirstK(int[] array, int start, int end, int k) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (array[mid] > k) {
                end = mid - 1;
            }else if (array[mid] < k) {
                start = mid + 1;
            }else {
                if ((mid > 0 && array[mid-1] != k) || mid == 0) return mid;
                else end = mid - 1;
            }
        }
        return -1;
    }
    private static int getLastK(int[] array, int start, int end, int k) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (array[mid] > k) {
                end = mid - 1;
            }else if (array[mid] < k) {
                start = mid + 1;
            }else {
                if ((mid < array.length - 1 && array[mid+1] != k) || mid == array.length-1) return mid;
                else start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,3,4};
        System.out.println(GetNumberOfK(a,2));
    }

}
