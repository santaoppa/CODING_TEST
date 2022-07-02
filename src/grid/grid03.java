package grid;

import java.util.Arrays;
import java.util.Scanner;

public class grid03 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt(); //5
        int m = sc.nextInt(); //8
        int k = sc.nextInt(); //3

        int[] arr = new int[n]; // 2 4 5 4 6
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int first = arr[n-1]; //6
        int second = arr[n-2]; //5

        int count = (m/(k+1)) * k + (m%(k+1));

        int result = 0;
        result += (count)*first;
        result += (m-count)*second;

        System.out.println(result); //46




    }
}
