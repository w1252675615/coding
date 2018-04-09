package Interview.Microsoft;
/*
    有一组数组，每次遍历一次数组，遇到一个比它左边的数大的数就标记，然后遍历一遍之后，删除那些标记的值。然后不断重复，问需要多少次能结束这样的操作
 */
public class Pulltree {
    public static int getTimes(int[] trees) {
        if (trees == null || trees.length < 2) return 0;
        int minOfMin = 0;   //遍历过的下坡的最小值点
        int lastMin = 0;    //上一个下坡的最小值点
        int minOfMax = 0;   //取得Max的下坡的最小值点
        int curCount =  0;
        int Max = 0;
        boolean isUp = false;

        if (trees[0] >= trees[1]) {
            while (lastMin < trees.length -1 && trees[lastMin] >= trees[lastMin+1]) ++lastMin;
            minOfMin = lastMin;
        }
        for (int i = lastMin + 1; i <trees.length; ++i) {
            if (trees[i-1] < trees[i]) { //上坡
                if (!isUp) {     //上坡的起点
                    isUp = true;
                    curCount = 0;
                    lastMin = i-1;
                    minOfMin = trees[minOfMin] < trees[lastMin] ? minOfMin : lastMin;
                }
            }else { //下坡或平
                if (trees[i] > trees[lastMin]) { //会因为比上一个下坡最低点高被拔掉
                    if (isUp) {
                        isUp = false;
                        ++curCount;// 下坡的起点，计数要算上坡顶
                    }
                    ++curCount;
                    if (curCount >= Max) { //注意这个等号
                        Max = curCount;
                        minOfMax = i;
                    }
                }else if (trees[i] > trees[minOfMin] && trees[i] <= trees[minOfMax]) {
                      ++Max;
                      minOfMax = i; //用例f，两个3让++max，后面654的4比3大所有没有++max
                }
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] a = {3,6,9,8};
        int[] b = {3,2,1,2,3,2,1,5,4,3,2,1,5,4};
        int[] c ={2,1};
        int[] d = {1,5,4,3,5,4,5,3};
        int[] e = {1, 7, 6, 5, 2, 6, 5, 4, 6, 5, 6, 3};
        int[] f = {1,7,6,5,4,5,6,3,5,6,3,6,5,4};
        System.out.println(getTimes(f));

    }
}
