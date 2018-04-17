package Important;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void basicSort(int[] a, int lo, int hi) {
        if(lo >= hi) return;
        int j = basicPartition2(a,lo,hi);
        basicSort(a,lo,j-1);
        basicSort(a,j+1,hi);
    }
    private int basicPartition(int[] a ,int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while(true) {
            while(a[lo] > a[++i]) {
                if (i == hi) break;
            }
            while(a[lo] < a[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(a,i,j);
        }
        exchange(a,j,lo);
        return j;
    }
    private int basicPartition2(int[] a ,int lo, int hi) {
        Random random = new Random(100);
        int index = random.nextInt(hi-lo);
        exchange(a,index,hi);
        int small = lo - 1;
        for (index=lo;index<hi;++index) {
            if (a[index] < a[hi]) {
                ++small;
                if (index != small) exchange(a,small,index);
            }
        }
        ++small;
        exchange(a,small,hi);
        return small;
    }
    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            int r = random.nextInt(i+1);
            exchange(a,i,r);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{1,2,3,4,5};
        quickSort.shuffleArray(a);
        System.out.println("shuffled arrays "+ Arrays.toString(a));
        quickSort.basicSort(a,0,a.length-1);
        System.out.println("sorted" + Arrays.toString(a));
    }
}
