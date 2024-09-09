
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			
			double [] A = new double[n];
			
			for(int i=0; i<n; i++) {
				
				A[i] = sc.nextDouble();
			}
		
			System.out.printf("%.3f", multiplySequence(n, A));
		
		
		sc.close();
	}
	
	public static double multiplySequence(int n, double [] A) {
		
		double [] dp = new double[10001];
		
		dp[0] = A[0];
		double max = A[0];
		
		for(int i=1; i<n; i++) {
			
			dp[i] = Math.max(dp[i-1]*A[i], A[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
