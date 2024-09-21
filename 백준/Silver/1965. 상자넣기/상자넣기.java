
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			
			int [] box = new int[n];
			
			for(int i=0; i<n; i++) {
				
				box[i] = sc.nextInt();
			}
			
			System.out.println(maximumBox(box, n));
		
	}
	
	public static int maximumBox(int [] box, int n) {
		
		int [] dp = new int[n];
		int max = 1;
		
		Arrays.fill(dp, 1);
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				
				if(box[i] > box[j]) {
					
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
