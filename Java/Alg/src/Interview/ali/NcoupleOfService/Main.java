package Interview.ali.NcoupleOfService;

import java.util.*;
/*
    n对客服，每对出一人，m对约束表示不能一起出现的人，问是否存在这n个人的方案，存在输出yes
    1-n对依次是，(1,2),(3,4),(5,6)...
 */

public class Main {

    private static boolean corePath(Map<Integer,Set<Integer>> map, int[] path, int index,int num, int n) {
        if (index >= n) return true;
        boolean hasPath = false;
        if (2*index+1 == n || 2*index+2 == n) {
            path[index++] = n;
            hasPath = corePath(map,path,index,2*index+1,n) || corePath(map,path,index,2*index+2,n);
        }
        return hasPath;
    }
    private static boolean checkNum(int num, Map<Integer,Set<Integer>> map, int[] path,int index) {
        boolean res = true;
        if (index >= 1) {
            if (map.containsKey(num)) {
                Set set = map.get(num);
                for (int i = 0; i < index; ++i) {
                    if (set.contains(2 * i + path[i])) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String res = "no";
            int n = sc.nextInt();
            int m = sc.nextInt();
            Map<Integer,Set<Integer>> map = new HashMap<>(m);
            for (int i = 0; i < m; ++i) {
                String s = sc.nextLine();
                String[] two = s.split(",");
                Integer a = Integer.valueOf(two[0]);
                Integer b = Integer.valueOf(two[1]);
                if (a.compareTo(b) < 0) {
                    Integer temp = a;
                    a = b;
                    b = temp;
                }
                if (map.containsKey(a)) {
                    Set set = map.get(a);
                    set.add(b);
                }else {
                    Set set = new HashSet();
                    set.add(b);
                    map.put(a,set);
                }
            }
            int[] path = new int[n];
            int index = 0;
            if (corePath(map,path,0,1,n) || corePath(map,path,0,2,n)) {
                res = "yes";
            }
            System.out.println(res);
        }
    }
}
