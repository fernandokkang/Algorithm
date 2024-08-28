
import java.util.*;

public class Main {
	
	static boolean[][] palindrome;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			String s = sc.next();
			
			System.out.println(partitionPalindrom(s));
		
	}
	
	public static int partitionPalindrom(String s) {
		
		int n = s.length();
		
		palindrome = new boolean[n+1][n+1];
		
		int [] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			
			dp[i] = Integer.MAX_VALUE;
		}
		
		checkPalindrom(s);
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				
				if (palindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
		
		return dp[n];
	}
	
	public static void checkPalindrom(String s) {
		
		int n = s.length();
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				
				boolean flag = true;
				
				int k = i-1;
				int l = j-1;
				
				while(k <= l) {
					
					if(s.charAt(k++) != s.charAt(l--)) {
						
						flag = false;
						break;
					}
				}
				
				if(flag) palindrome[i][j] = true;
 			}
		}
	}
}
