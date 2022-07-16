package graph;

import java.util.Arrays;
import java.util.Scanner;

public class graph04 {
    public static final int INF = (int) 1e9;
    public static int n, m, x, k;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<101; i++){
            Arrays.fill(graph[i], INF); // 최단 거리 테이블 모두 무한으로 초기화
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) graph[i][j] = 0; // 자기 자신으로 가는 비용 0으로 초기화
            }
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt(); // 방문해야하는 회사 위치
        k = sc.nextInt(); // 소개팅 참석 회사 위치

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if(distance >= INF) System.out.println(-1);
        else System.out.println(distance);
    }
}
