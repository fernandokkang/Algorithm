
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
	
			int n = sc.nextInt();
			
			int [][] wire = new int[n][2];
			for(int i=0; i<n; i++) {
				
				wire[i][0] = sc.nextInt();
				wire[i][1] = sc.nextInt();
			}
			
			System.out.println(removeWires(wire, n));
		
		
	}
	
	public static int removeWires(int [][] wire, int n) {
		
		int [] dp = new int[n];
		int max = 0;
		
		Arrays.fill(dp, 1);
		
		Arrays.sort(wire, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] - o2[0];
			}
		});
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				
				if(wire[i][1] > wire[j][1]) {
					
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return n-max;
	}
}

