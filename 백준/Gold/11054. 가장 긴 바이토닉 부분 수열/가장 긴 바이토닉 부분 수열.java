

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			
			int n = sc.nextInt();
			
			int [] A = new int[n];
			
			for(int i=0; i<n; i++) {
				
				A[i] = sc.nextInt();
			}
			
			System.out.println(BitonicSequence(n, A));
		
	}
	
	public static int BitonicSequence(int n, int [] A) {
		
		int [] dp  = new int[n];
		int [] dp1 = new int[n];
		int [] dp2 = new int[n];
		
		int max = 0;
		
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				
				if(A[i] > A[j]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=n-1; j>i; j--) {
				
				if(A[i] > A[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			
			dp[i] = dp1[i] + dp2[i] - 1;
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
