
import java.util.*;

public class Main {
	
public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			
			String str1 = sc.next();
			String str2 = sc.next();
			
			System.out.println(LCS(str1, str2));
		
	}

	public static int LCS(String str1, String str2) {
		
		int n = str1.length();
		int m = str2.length();
		int max = 0;
		
		int [][] dp = new int[n+1][m+1];
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				
				if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				
				max = Math.max(max, dp[i][j]);
			}
		}
		
		
		return max;
	}
	
}
