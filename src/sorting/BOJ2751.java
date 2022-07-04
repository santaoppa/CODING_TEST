package sorting;

import java.util.*;

public class BOJ2751 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0; i<n; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            sb.append(arr.get(i) + "\n");
        }

        System.out.println(sb);
    }
}