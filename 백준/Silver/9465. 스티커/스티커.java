

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			
			
			int n = sc.nextInt();
			
			int [][] stk = new int[2][n+1];
			
			for(int i=0; i<2; i++) {
				for(int j=1; j<=n; j++) {
					
					stk[i][j] = sc.nextInt();
				}
			}
			
			
			System.out.println(detachSticker(stk, n));
		}
	}
	
	public static int detachSticker(int [][] stk, int n) {
		
		int [][] dp = new int[2][100001];
		
		dp[0][1] = stk[0][1];
		dp[1][1] = stk[1][1];
		
		for(int j=2; j<=n; j++) {
			
			dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stk[0][j];
			dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stk[1][j];
		}
		
		return Math.max(dp[0][n], dp[1][n]);
	}
}
