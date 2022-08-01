package dynamicProgramming;

import java.util.*;

public class dp03 {

    static int n;
    static int[] dp = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2 += 1;
                next2 = dp[i2] * 2;
            }
            if (dp[i] == next3) {
                i3 += 1;
                next3 = dp[i3] * 3;
            }
            if (dp[i] == next5) {
                i5 += 1;
                next5 = dp[i5] * 5;
            }
        }

        System.out.println(dp[n - 1]);
    }
}