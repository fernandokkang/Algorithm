import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			System.out.println(colorCircle(n, k));
		
	}
	
	public static int colorCircle(int n, int k) {
		
		int [][] dp = new int[n+1][k+1];
		int mod = 1000000003;
		
		for(int i=1; i<=n; i++) {
			
			dp[i][1] = i;
		}
		
		for(int i=4; i<=n; i++) {
			for(int j=2; j<=k; j++) {
				
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % mod;
			}
		}
		
		return dp[n][k];
	}
}
