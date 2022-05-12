package grid;

import java.util.Scanner;

public class grid_0511_3_3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;

        for(int i = 0; i < n; i++) {
            int min = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                //if (x < min) min = x;
                min = Math.min(min, x);
            }
            //if (min > max) max = min;
            max = Math.max(max, min);
        }

        System.out.println(max);

    }
}
