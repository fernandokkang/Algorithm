
import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			
			ArrayList<Integer> soldier = new ArrayList<Integer>();
			
			
			for(int i=0; i<n; i++) {
				soldier.add(sc.nextInt());
			}
			
			System.out.println(soldierDeployment(soldier));
			
		
	}
	
	public static int soldierDeployment(ArrayList<Integer> soldier) {
		
		int n = soldier.size();
		
		int [] dp = new int [n];
		
		Arrays.fill(dp, 1);
		
		Collections.reverse(soldier);

		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(soldier.get(i) > soldier.get(j)) {
					
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			
			max = Math.max(dp[i], max);
		}
		
		return n - max;
	}
}
