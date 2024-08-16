

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int [] coin = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				
				coin[i] = sc.nextInt();
			}
			
			System.out.println(numberOfCasesForCoin(n, k, coin));
		
	}
	
	public static int numberOfCasesForCoin(int n, int k, int [] coin) {
		
		int [] dp = new int[k+1];
		
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
		
		return dp[k];
	}
}
