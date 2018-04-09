package Offer.Q21_ReorderArray;
/*
    调整数组，使得奇数位于偶数前面
    注意：奇数（偶数）之间相对顺序不能改变
 */
public class ReorderArray {
    private boolean isFit(int x) {
        return (x&1)==1;
    }
    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void reOrderArray(int [] array) {
        for (int i = 1;i < array.length;++i) {
            for (int j = i;j > 0;--j) {
                if (isFit(array[j])&&!isFit(array[j-1])) swap(array,j,j-1);
                else break;
            }
        }
    }
}
