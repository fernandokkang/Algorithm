

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int [] sugar = {3, 5};
		
	
			int n = sc.nextInt();
			
			System.out.println(optimalSugarDeilvery(sugar, n));
		
	}
	
	public static int optimalSugarDeilvery(int [] sugar, int n) {
		
		int [] dp = new int [n+1];
		
		int m = sugar.length;
		
		Arrays.fill(dp, 5001);
		
		dp[0] = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=sugar[i]; j<=n; j++) {
				
				if(dp[j - sugar[i]] != 5001) {
					
					dp[j] = Math.min(dp[j], dp[j - sugar[i]] + 1);
				}
			}
		}
		if(dp[n] != 5001) return dp[n];
		else return -1;
	}
}
