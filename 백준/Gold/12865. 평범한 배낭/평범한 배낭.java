

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int [] w = new int[n+1];
			int [] v = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				
				w[i] = sc.nextInt();
				v[i] = sc.nextInt();
			}
			
			System.out.println(knapsack(n, k, w, v));
		
	}
	
	public static int knapsack(int n, int k, int [] w, int [] v) {
		
		int [][] dp = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
			
				if(w[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i], dp[i-1][j]);
			}			
		}
		
		return dp[n][k];
	}
}
