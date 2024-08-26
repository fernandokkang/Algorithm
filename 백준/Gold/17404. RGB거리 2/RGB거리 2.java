
import java.util.*;

public class Main {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);


			int n = sc.nextInt();
			
			int [][] cost = new int[1000][3];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<3; j++) {
					
					cost[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(housePainting(cost, n));
		
	}
	
	public static int housePainting(int [][] cost, int n) {
		
		int [][] dp = new int[1000][3];
		
		int minCost = 1000001;
		
		for(int k=0; k<3; k++) {
			
			for(int i=0; i<3; i++) {
				
				if(i==k) dp[0][i] = cost[0][i];
				else dp[0][i] = 1000001;
			}
			
			for(int i=1; i<n; i++) {
				
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + cost[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
			}
			
			for(int i=0; i<3; i++) {
				if(i != k) minCost = Math.min(minCost, dp[n-1][i]);
			}
		}
		
		return minCost;
	}
}
