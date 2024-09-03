
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			
			int n = sc.nextInt();
			int t = sc.nextInt();
			
			int [] k = new int[n+1];
			int [] s = new int[n+1];
			
			for(int i=1; i<=n; i++) {
				
				k[i] = sc.nextInt();
				s[i] = sc.nextInt();
			}
			
			System.out.println(maximumScore(n, t, k, s));
		
}
	
	public static int maximumScore(int n, int t, int [] k, int [] s) {
		
		int [][] dp = new int[101][10001];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=t; j++) {
			
				if(k[i] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j-k[i]] + s[i], dp[i-1][j]);
			}			
		}
		
		return dp[n][t];
	}
}
