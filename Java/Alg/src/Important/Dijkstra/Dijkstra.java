package Important.Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    使用邻接表和优先队列（小根堆）的D算法
    顶点从1开始
 */
public class Dijkstra {
    int n;//点数
    int m;//边数
    //邻接表
    private int[] U; //第i条边的起点
    private int[] V; //第i条边的终点
    private int[] W; //第i条边的长度
    private int[] first; //起点为i的第一条边
    private int[] next; //起点为i的下一条边，-1表示没了
    class distanceTo {
        int des;
        int distance;
        distanceTo(int des, int distance) {
            this.des = des;
            this.distance = distance;
        }
    }
    Dijkstra(int n, int m, int[][] edges) {  //点数，边数，输入数组（起点,终点,长度）
        if (m != edges.length) throw new IllegalArgumentException();
        U = new int[m+1];
        V = new int[m+1];
        W = new int[m+1];
        first = new int[n+1];
        next = new int[n+1];
        for (int i = 0; i < edges.length; ++i) { //读入每一条边
            if (edges[i].length != 3) throw new IllegalArgumentException();
            U[i+1] = edges[i][0];
            V[i+1] = edges[i][1];
            W[i+1] = edges[i][2];
        }
        for (int i = 1; i < first.length; ++i) {
            first[i] = -1;
        }
        for (int i = 1; i <= m; ++i) {
            next[i] = first[U[i]]; //邻接表的关键
            first[U[i]] = i;
        }
    }
    public int[] findNearestPath(int s) { //源点i到其他点的最短路
        PriorityQueue<distanceTo> updatingDistance = new PriorityQueue<>(new Comparator<distanceTo>() {
            @Override
            public int compare(distanceTo o1, distanceTo o2) {
                return o1.distance - o2.distance;
            }
        });
        int[] distance = new int[n+1];
        for (int i = 1; i < first.length; ++i) {
            if (i == s) continue;
            distance[i] = Integer.MAX_VALUE;
        }
        int[] path = new int[n+1];

        int i = first[s];
        if (i == -1) return path;
        while (i != -1) { //遍历s为源点的所有边
            distance[V[i]] = W[i];
            updatingDistance.offer(new distanceTo(V[i], W[i]));
            i = next[i];
        }
        for (i = 1; i <= n; i++) { //因为邻接表不会存不能直达的点
            if (distance[i] == Integer.MAX_VALUE) updatingDistance.offer(new distanceTo(i,distance[i]));
        }
        for (i = 1; i <= n-1; ++i) { //D算法要循环n-1次
            int t = first[updatingDistance.poll().des]; //当前到点w距离最短

            while (t != -1) {
                if(distance[V[i]] > distance[U[i]] + W[i]) {
                    distance[V[i]] = distance[U[i]] + W[i];
                    updatingDistance.offer(new distanceTo(V[i],distance[V[i]]));//不需要删掉被覆盖的，因为他们会被排在后面
                    path[V[i]] = U[i];
                }
            }
        }
        return path;
    }
}
