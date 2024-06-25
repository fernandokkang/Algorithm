import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] stones = new int[N+1];
        int [] dp = new int[N+1];
        int answer = 0;

        for(int i=1; i<=N; i++) {
            stones[i] = sc.nextInt();
        }
        
        for(int i=1; i<=N; i++) {
            dp[i] = 1;
            for(int j=1; j<i; j++) {
                if(stones[i] > stones[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
