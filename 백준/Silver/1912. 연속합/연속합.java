

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
	
	public static int sumOfN(int [] N, int n) {
		
		int [] dp = new int [n];
		int max = N[0];
		
		dp[0] = N[0];
		
		for(int i=1; i<n; i++) {
			
			dp[i] = Math.max(N[i], dp[i-1] + N[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
