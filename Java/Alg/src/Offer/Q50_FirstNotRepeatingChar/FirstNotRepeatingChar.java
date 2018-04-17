package Offer.Q50_FirstNotRepeatingChar;

import java.util.LinkedHashMap;

public class FirstNotRepeatingChar {
    //Insert one char from stringstream
    private LinkedHashMap<Character,Integer> chars = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if (!chars.containsKey(ch)) {
            chars.put(ch,1);
        }else {
            chars.put(ch,-1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        for (char ch : chars.keySet()) {
            if (chars.get(ch) == 1) {
                res = ch;
                break;
            }
        }
        return res;
    }
}
