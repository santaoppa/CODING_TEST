package dynamicProgramming;

import java.util.*;

public class BOJ2156 {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp =new int [n+1];
        int[] cost = new int [n+1];

        for(int i=1;i<=n; i++) {
            cost[i] = sc.nextInt();
        }

        dp[1] = cost[1];
        if(n>=2){
            dp[2] = Math.max(dp[1] + cost[2], cost[2]);
        }

        for(int i=3;i<=n; i++) {
            if(n>=3)
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + cost[i-1]+ cost[i], dp[i-2]+cost[i]));
        }
        System.out.println(dp[n]);
    }
}