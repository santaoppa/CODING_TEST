package search;

import java.util.Scanner;

public class B1012 {
    public static int M, N, K;
    public static int[][] map;

    public static boolean dfs(int x, int y){
        if(x<=-1||x>=M||y<=-1||y>=N) return false;

        if(map[x][y]==1){
            map[x][y]=2;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  //테스트 케이스 개수

        for(int i=0; i<T; i++){
            M = sc.nextInt();   //배추밭 가로
            N = sc.nextInt();   //배추밭 세로
            K = sc.nextInt();   //배추 위치 개수

            map = new int[M][N];
            for(int k = 0; k<K; k++){
                int dx = sc.nextInt();
                int dy = sc.nextInt();
                map[dx][dy]=1;
            }

            int result = 0;
            for(int m=0; m<M; m++){
                for(int n=0; n<N; n++){
                    if(dfs(m,n)){
                        result+=1;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
