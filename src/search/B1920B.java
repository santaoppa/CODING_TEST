package search;

import java.util.*;

public class B1920B {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr1[] = new int[N];
        for(int i=0; i<N; i++) arr1[i]=sc.nextInt();

        Arrays.sort(arr1);

        int M = sc.nextInt();
        int arr2[] = new int[M];
        for(int i=0; i<M; i++) arr2[i]=sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            int index = Arrays.binarySearch(arr1, arr2[i]);
            if(index < 0) sb.append(0+"\n");
            else sb.append(1+"\n");
        }

        System.out.println(sb);
    }
}