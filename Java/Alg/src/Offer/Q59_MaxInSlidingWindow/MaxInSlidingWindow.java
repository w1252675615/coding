package Offer.Q59_MaxInSlidingWindow;
/*
    大小为size的滑动窗口，求每个窗口中的最大值
    关键是不把每个数存入双端队列，如果当前数大于队列左边的数，则这些数都不可能为最大值
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxInSlidingWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || num.length < 1 || size < 1) return res;
        Deque<Integer> maxInWindows = new ArrayDeque<>();
        for (int i = 0; i < size; ++i) {
            while (!maxInWindows.isEmpty() && num[i] > num[maxInWindows.peekLast()]) maxInWindows.pollLast();
            maxInWindows.offerLast(i);
        }
        res.add(num[maxInWindows.peekFirst()]);
        for (int i = size; i < num.length; ++i) {
            if (!maxInWindows.isEmpty() && i-maxInWindows.peekFirst() >= size) maxInWindows.pollFirst();
            while (!maxInWindows.isEmpty() && num[i] > num[maxInWindows.peekLast()]) maxInWindows.pollLast();
            maxInWindows.offerLast(i);
            res.add(num[maxInWindows.peekFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a,3));
    }
}
