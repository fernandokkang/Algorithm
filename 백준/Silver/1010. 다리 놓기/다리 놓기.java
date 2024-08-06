
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println(bridge(n, m));
		}
	}
	
	public static long bridge(int n, int m) {
		
		long [][] dp = new long[31][31];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				
				if(i == 0 || i == j) dp[i][j] = 1;
				
				else if(i < j) dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				
			}
		}
		
		return dp[n][m];
	}
}
