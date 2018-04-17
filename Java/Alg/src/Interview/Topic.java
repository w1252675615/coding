package Interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Topic {
    static class Tree{
        char x;
        HashSet<Tree> next;
        Tree(char x) {
            this.x = x;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character,Tree> map = new HashMap<>();
        HashSet<Character> root = new HashSet<>();
        while (in.hasNext()) {
            char[] line = in.nextLine().toCharArray();
            try {
                if (!map.containsKey(line[0])) {
                    map.put(line[0],new Tree(line[0]));
                    root.add(line[0]);
                }
                if (!map.containsKey(line[2])) map.put(line[2],new Tree(line[2]));
                if (root.contains(line[2])) root.remove(line[2]);
                if (!map.get(line[0]).next.contains(map.get(line[2]))) map.get(line[0]).next.add(map.get(line[2]));
            }catch (NullPointerException e){}
        }

    }
}
