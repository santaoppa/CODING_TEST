package grid;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class b2839B {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        int result = 0;

        while (sugar >= 0){
            if(sugar % 5 == 0){
                result += sugar/5;
                break;
            }
            if(sugar < 3){
                result = -1;
                break;
            }
            sugar -= 3;
            result += 1;
        }

        System.out.println(result);

    }
}