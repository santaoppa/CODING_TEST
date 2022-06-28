package search;

import java.io.*;
import java.util.*;

public class B1260 {
    static int N,M,V;
    static int[][] dfs, bfs;
    static boolean[] dVisited, bVisited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        dfs = new int[N+1][N+1];
        bfs = new int[N+1][N+1];
        dVisited = new boolean[N+1];
        bVisited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            dfs[m][n] = dfs[n][m] = 1;
            bfs[m][n] = bfs[n][m] = 1;
        }

        sb = new StringBuilder();
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        dVisited[node] = true;
        sb.append(node + " ");
        for(int i = 1; i<= N; i++){
            if(dfs[node][i] == 1 && !dVisited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        bVisited[node] = true;
        que.offer(node);

        while(!que.isEmpty()) {
            int temp = que.poll();
            sb.append(temp + " ");
            for(int i=1; i<=N; i++) {
                if(bfs[temp][i] == 1 && !bVisited[i]) {
                    bVisited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}