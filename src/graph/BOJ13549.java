package graph;

import java.util.*;

class Node implements Comparable<Node> {
    public int index;
    public int time;

    public Node (int index, int time) {
        this.index = index;
        this.time = time;
    }

    public int compareTo(Node n) {
        return this.time - n.time;
    }
}

public class BOJ13549 {
    public static final int INF = (int) 1e9;
    public static int n, k;
    public static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Arrays.fill(d, INF);

        dijkstra();
        System.out.println(d[k]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(n, 0));
        d[n] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (d[curNode.index] < curNode.time) continue;

            int[] route = new int[] {curNode.index-1, curNode.index+1, curNode.index*2};
            for(int i=0; i<route.length; i++) {
                if(route[i] < 0 || route[i] > 100000) continue;

                Node nextNode = new Node(route[i], (i == 0 || i == 1) ? 1 : 0);
                if(d[nextNode.index] > d[curNode.index] + nextNode.time) {
                    pq.offer(nextNode);
                    d[nextNode.index] = d[curNode.index] + nextNode.time;
                }
            }
        }
    }
}