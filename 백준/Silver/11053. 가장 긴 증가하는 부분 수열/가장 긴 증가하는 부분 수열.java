

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
	
			int n = sc.nextInt();
			
			int [] A = new int[n];
			
			for(int i=0; i<n; i++) {
				
				A[i] = sc.nextInt();
			}
			
			System.out.println(LongestIncreaseSequence(A, n));
		
	}
	
	public static int LongestIncreaseSequence(int [] A, int n) {
		
		int [] dp = new int[n];
		
		int max = 0;
		
		Arrays.fill(dp, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				
				if(A[i] > A[j]) {
					
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
