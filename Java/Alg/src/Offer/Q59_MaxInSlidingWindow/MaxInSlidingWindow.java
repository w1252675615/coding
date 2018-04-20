package Offer.Q59_MaxInSlidingWindow;

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
        for (int i = size; i < num.length; ++i) {
            res.add(num[maxInWindows.peekFirst()]);
            while (!maxInWindows.isEmpty() && num[i] > num[maxInWindows.peekLast()]) maxInWindows.pollLast();
            if (!maxInWindows.isEmpty() && i-maxInWindows.peekFirst() >= size) maxInWindows.pollFirst();
            maxInWindows.offerLast(i);
        }
        res.add(num[maxInWindows.peekFirst()]);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a,3));
    }
}
