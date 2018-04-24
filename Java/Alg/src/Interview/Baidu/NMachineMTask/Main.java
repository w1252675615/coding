package Interview.Baidu.NMachineMTask;
/*
    这道题的意识是给你N个机器和M个任务， 每个任务有两个值花费时间x和难度y,
     每个机器也有两个值最大工作时间x1和最大工作难度y1， 机器可以胜任某个工作的条件是x1>=x && y1>=y,
     机器胜任一个工作可以拿到x*500+2*y的钱，现在问你怎么匹配才能使匹配数最大且钱数最多。
      由于数据量过大我们考虑使用贪心来解决这道题， 由于x的权重远大于y的权重，因此我们将工作按照x降序排列，
      x相同的时候按照y降序排列， 这样就可以保证钱数最多，
      对于一个工作我们可以选择的是所有x1>x的机器， 而在这些机器中我们选择最小的y1，
      为什么这样选呢， 因为这样选就可以保留比较大的y1使其去匹配后面的任务，
      而x1则完全不用操心， 他肯定可以匹配后面的任务， 因为任务是按照x降序排列的
 */
import java.util.Scanner;
import java.util.TreeSet;

class node implements Comparable<node>{
    int x;
    int y;
    node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(node o) {
        if (this.x == o.x) return o.y-this.y;
        return o.x-this.x;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int M = sc.nextInt(); //machines
            int T = sc.nextInt(); //Tasks
            TreeSet<node> machines = new TreeSet<>();
            TreeSet<node> tasks = new TreeSet<>();
            int money = 0;
            int num = 0;
            for (int i = 0; i < M; ++i) {
                machines.add(new node(sc.nextInt(),sc.nextInt()));
            }
            for (int i = 0; i < M; ++i) {
                tasks.add(new node(sc.nextInt(),sc.nextInt()));
            }
            for(node task : tasks) {
                node machine = machines.ceiling(task);
                if (machine == null) continue;
                money += 500*task.x + 2*task.y;
                num += 1;
            }
            System.out.println(num + " " +money);
        }
    }
}