import java.util.*;

public class Main {

	static int n;
	static int m;
	
	static int [][] network;
	static boolean [] visited;
	
	static int virus = 0;
	
	static void dfs(int start) {
		
		visited[start] = true;
		
		for(int i=1; i<=n; i++) {
			
			if(network[start][i] == 1 && !visited[i]) {
				
				virus++;
				dfs(i);
			}
		}
	}
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        network = new int [n+1][n+1];
        visited = new boolean [n+1];
        
        for(int i=1; i<=m; i++) {
        	
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	
        	network[x][y] = network[y][x] = 1;
        }
            
        dfs(1);
        System.out.println(virus);
    }
}
