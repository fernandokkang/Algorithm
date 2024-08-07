

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			
			int n = sc.nextInt();
			
			System.out.println(padovanSequence(n));
		}
	}
	
	public static long padovanSequence(int n) {
		
		long [] dp = new long[101];
		
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		
		for(int i=6; i<=n; i++) {
			
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		return dp[n];
	}
}
