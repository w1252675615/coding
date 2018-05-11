package Interview.ali.NewP;

import java.util.*;


public class Main {

    private static int startOfDigits(int digits) {
        return (int)Math.pow(10.0,(double) (digits-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String res = "yes";
            int n = sc.nextInt();
            int m = sc.nextInt();
            Map<Integer,Integer> re = new HashMap<Integer, Integer>(m);
            for (int i = 0; i < m; ++i) {
                String s = sc.nextLine();
                String[] two = s.split(",");
                Integer a = Integer.valueOf(two[0]);
                Integer b = Integer.valueOf(two[1]);
                if (a.compareTo(b) > 0) {
                    Integer temp = a;
                    a = b;
                    b = temp;
                }
                re.put(a,b);
            }
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(re.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
                        //升序排序
                        public int compare(Map.Entry<Integer, Integer> o1,
                                           Map.Entry<Integer, Integer> o2) {
                            return o1.getKey().equals(o2.getKey()) ? o1.getValue().compareTo(o2.getValue())
                                    : o1.getKey().compareTo(o2.getKey());
                        }
                    });
            int[][] dp = new int[n][m];
            int index = 0;
            int safer = 0;
            for (int i = 0; i < n; ++i) {
                if (2*(i+1) < list.get(index).getKey())
            }
            System.out.println(res);
        }
    }
}
