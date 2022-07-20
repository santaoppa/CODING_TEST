package search;

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
    public static int n, k;
    public static boolean[] visited = new boolean[100001];
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        bfs();
        System.out.println(result);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n,0));

        while(!q.isEmpty()){
            Node curNode = q.poll();
            visited[curNode.index] = true;

            if(curNode.index == k){
                result = Math.min(result, curNode.time);
            }
            if(curNode.index*2 <= 100000 && !visited[curNode.index*2]){
                q.offer(new Node(curNode.index*2, curNode.time));
            }
            if(curNode.index+1 <= 100000 && !visited[curNode.index+1]){
                q.offer(new Node(curNode.index+1, curNode.time+1));
            }
            if(curNode.index-1 >= 0 && !visited[curNode.index-1]){
                q.offer(new Node(curNode.index-1, curNode.time+1));
            }
        }
    }


}