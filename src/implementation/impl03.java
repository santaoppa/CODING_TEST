package implementation;

import java.util.Scanner;

public class impl03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';        //'0'의 아스키코드는 48
        int col = inputData.charAt(0) - 'a' + 1;    //'a'의 아스키코드는 97

        int[] dx = {-2, -1, 1, 2, 2, 1 ,-1, -2};
        int[] dy = {-1, -2, -2, -1, 1 ,2 ,2, 1};

        int result = 0;

        for(int i = 0; i < 8; i++){
           int nx = row + dx[i];
           int ny = col + dy[i];

           if(nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) result += 1;
        }

        System.out.println(result);
    }
}
