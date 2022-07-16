package graph;

import java.util.*;

public class graph03 {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값 설정(연결되지 않은 간선)
    public static int n, m; // 노드의 개수(n), 간선의 개수(m)
    public static int[][] graph = new int[501][501];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<501; i++){
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
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 위셜 알고리즘 수행
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        // 수행된 결과를 출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph[i][j] == INF) System.out.print("INFINITY ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
