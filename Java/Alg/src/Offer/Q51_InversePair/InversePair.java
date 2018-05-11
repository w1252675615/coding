package Offer.Q51_InversePair;

public class InversePair {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) return 0;
        int[] aux = new int[array.length];
        /*for (int i = 0; i < array.length;++i) {
            aux[i] = array[i];
        }*/
        return coreInversePair(array,aux,0,array.length-1);
    }
    private int coreInversePair(int[] array, int[] aux, int lo, int hi) {
        if (lo >= hi) return 0;
        int middle = lo + (hi-lo)/2;
        int left = coreInversePair(aux,array,lo,middle)%1000000007;
        int right = coreInversePair(aux,array,middle+1,hi)%1000000007;
        int count = 0;
        int i = middle;
        int j = hi;
        int index = hi;
        while (index >= lo) {
            if (j < middle+1) {
                aux[index--] = array[i--];
            }else if (i < lo) {
                aux[index--] = array[j--];
            }else if (array[i] > array[j]) {
                count += j-middle;
                count %= 1000000007;
                aux[index--] = array[i--];
            }else {
                aux[index--] = array[j--];
            }
        }
        return (left+right+count)%1000000007;
    }

    public static void main(String[] args) {
        int[] a = {7,5,6,4};
        InversePair inversePair = new InversePair();
        System.out.println(inversePair.InversePairs(a));
    }
}
