package search;

import java.util.*;

public class BOJ1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        long N = sc.nextLong();

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        //이분탐색
        long start = 1;
        long end = arr[K-1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for(long i : arr){
                total += (i/mid);
            }
            if (total >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}

