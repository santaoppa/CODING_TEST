package graph;

import java.util.*;

public class BOJ11404 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                graph[i][j] = INF;
                if(i==j) graph[i][j]=0;
            }
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b],c);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        StringBuilder sb =new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph[i][j] == INF) graph[i][j]=0;

                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
