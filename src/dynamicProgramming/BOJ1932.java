package dynamicProgramming;

import java.util.*;

public class BOJ1932 {
    public static int[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        d = new int[n+1][n+1];
        int arr[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + arr[i][j];
            }
        }

        int result=0;
        for(int i=1; i<=n; i++) {
            if(result < d[n][i]) result = d[n][i];
        }

        System.out.println(result);
    }
}