package Offer.Q39_MoreThanHalfNumber;

import java.util.Random;
public class MoreThanHalfNumberWithPartition {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int start = 0;
        int end = array.length-1;
        int middle = array.length >> 1;
        int index = partition(array,start,end);
        while (index != middle) {
            if (index < middle) {
                start = index+1;
                index = partition(array,start,end);
            }else {
                end = index - 1;
                index = partition(array,start,end);
            }
        }
        int result = array[index];
        int count = 0;
        for(int i = 0;i < array.length;++i) {
            if (array[i] == result) ++count;
        }
        if (2*count <= array.length) result = 0;
        return result;
    }
    private int partition(int[] array,int start,int end) {
        Random r = new Random(100);
        int index = r.nextInt(end-start+1);
        swap(array,end,index);
        int small = start - 1;
        for (index = start;index < end;++index) {
            if (array[index]<array[end]) {
                ++small;
                if(small != index)swap(array,index,small);
            }
        }
        swap(array,end,++small);
        return small;
    }
    private void swap(int[] array,int a,int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        MoreThanHalfNumberWithPartition moreThanHalfNumber = new MoreThanHalfNumberWithPartition();
        int[] a = {2,2,2,2,2,1,3,4,5};
        System.out.println(moreThanHalfNumber.MoreThanHalfNum_Solution(a));
    }
}
