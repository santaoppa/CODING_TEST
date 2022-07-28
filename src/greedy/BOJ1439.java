package greedy;

import java.util.Scanner;

public class BOJ1439 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int cnt0 = 0;
        int cnt1 = 0;

        if(str.charAt(0)=='1')  cnt0+=1;
        else cnt1+=1;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) != str.charAt(i+1)){
                if(str.charAt(i+1)=='1') cnt0+=1;
                else cnt1+=1;
            }
        }

        System.out.println(Math.min(cnt0, cnt1));
    }
}
