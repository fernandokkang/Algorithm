
import java.util.*;

public class Main {
	
public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		
			int n = sc.nextInt();
			
			int [] N = new int[n];
			
			for(int i=0; i<n; i++) {
				
				N[i] = sc.nextInt();
			}
			
			System.out.println(sumOfN(N, n));
		
	}

	public static int sumOfN(int[] N, int n) {

		int[][] dp = new int[100001][2];

		dp[0][0] = 0;
		dp[0][1] = N[0];
		int max = dp[0][1];
		
		for(int i=1; i<n; i++) {
			
			dp[i][0] = Math.max(dp[i-1][0] + N[i], dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1] + N[i], N[i]);
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		return max;
	}
}
