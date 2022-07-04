package search;

import java.util.*;

public class BOJ1920a {

    static int N, M;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int arr1[] = new int[N];
        for(int i=0; i<N; i++) arr1[i]=sc.nextInt();

        Arrays.sort(arr1);

        M = sc.nextInt();
        int arr2[] = new int[M];
        for(int i=0; i<M; i++) arr2[i]=sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) sb.append(binarySearch(arr1,arr2[i])+"\n");
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = N-1;
        int mid = 0;

        while(start <= end) {
            mid = (start+end)/2;
            if(arr[mid]==target) return 1;
            else if(arr[mid]>target) end = mid-1;
            else if(arr[mid]<target) start = mid+1;

        }
        return 0;

    }
}