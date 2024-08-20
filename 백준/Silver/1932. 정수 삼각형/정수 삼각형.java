

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		
			int n = sc.nextInt();
			
			int [][] Triangle = new int [n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					
					Triangle[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(SumOfTriangle(Triangle, n));
			
		
	}
	
	public static int SumOfTriangle(int [][] Triangle, int n) {
		
		int [][] dp = new int[n][n];
		int max = 0;
		
		dp[0][0] = Triangle[0][0];
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				
				if(j == 0) dp[i][j] = dp[i-1][j] + Triangle[i][j];
				else if(i == j) dp[i][j] = dp[i-1][j-1] + Triangle[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + Triangle[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			
			max = Math.max(max, dp[n-1][i]);
		}
		
		return max;
	}
}
