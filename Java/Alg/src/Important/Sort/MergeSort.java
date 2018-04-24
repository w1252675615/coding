package Important.Sort;

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr,int[] aux,int lo,int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int index = lo;index < hi;++index) {
            if (i  > mid) aux[index++] = arr[j++];
            if (j > hi) aux[index++] = arr[i++];
            if (arr[i] < arr[j]) aux[index++] = arr[i++];
            else aux[index++] = arr[j++];
        }
    }
    public static void mergeSort(int[] arr,int[] aux,int lo,int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo)/2;
        mergeSort(aux,arr,lo,mid);
        mergeSort(aux,arr,mid+1,hi);
        merge(arr,aux,lo,mid,hi);
    }


    public static void main(String[] args) {
            MergeSort mergeSort = new MergeSort();
            int[] a = new int[]{1,2,3,4,5};
            int[] aux = new int[a.length];
            for (int i = 0;i < a.length; ++i) {
                aux[i] = a[i];
            }
            mergeSort.mergeSort(a,aux,0,a.length);
            System.out.println("sorted" + Arrays.toString(a));
        }
}
