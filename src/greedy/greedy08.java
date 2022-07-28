package greedy;

import java.util.*;

public class greedy08 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        long result = s.charAt(0)-'0';

        for(int i=1; i<s.length(); i++){
            int num = s.charAt(i)-'0';
            if(num<=1 || result<=1){
                result += num;
            }else{
                result *= num;
            }
        }

        System.out.println(result);
    }
}
