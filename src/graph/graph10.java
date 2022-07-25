package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class graph10 {

    public static int v;
    public static int[] indegree = new int[501]; // 진입차수
    public static int[] times = new int[501]; // 각 강의 시간
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // 위상 정렬 함수
    public static void topologySort() {
        int[] result = new int[501]; // 최소 시간을 담는 결과 테이블
        for(int i=1; i<=v; i++){
            result[i]=times[i];
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        // 위상 정렬을 수행한 결과 출력
        for (int i = 0; i <= v; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i <= v; i++) {
            int x = sc.nextInt();
            times[i] = x;

            while(true){
                x = sc.nextInt();
                if ( x == -1) break;
                indegree[i] += 1;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
}