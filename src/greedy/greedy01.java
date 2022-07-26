package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedy01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for(int coin : coinTypes){
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
    }
}