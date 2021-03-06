package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        int result = 0;

        while(sugar > 0){
            if(sugar % 5 == 0){
                result += 1;
                sugar -= 5;
            }else if(sugar % 3 == 0){
                result += 1;
                sugar -= 3;
            }else if(sugar > 5){
                result += 1;
                sugar -= 5;
            }else{
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}
