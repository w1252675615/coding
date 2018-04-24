package Offer.Q45_SortArrayForMinNumber;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
    将一列数排成最小的数
 */
public class SortArrayForMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        ArrayList<String> numbersArr = new ArrayList<>();

        for (int i = 0; i < numbers.length; ++i) {
            numbersArr.add(String.valueOf(numbers[i]));
        }
        Collections.sort(numbersArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : numbersArr) {
            res.append(s);
        }
        return res.toString();
    }
}
