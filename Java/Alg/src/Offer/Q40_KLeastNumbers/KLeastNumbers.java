package Offer.Q40_KLeastNumbers;

import java.util.ArrayList;
import java.util.TreeSet;

public class KLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) return res;
        TreeSet<Integer> temp = new TreeSet<>();
        for (int i = 0; i < input.length;++i) {
            if (temp.size() < k) temp.add(input[i]);
            else {
                if (input[i] < temp.last()){
                    temp.pollLast();
                    temp.add(input[i]);
                }
            }
        }
        res.addAll(temp);
        return res;
    }
}
