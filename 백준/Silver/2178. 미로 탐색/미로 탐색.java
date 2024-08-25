import java.util.*;

public class Main {

	static int n;
	static int m;
	
	static int [][] map;
	static boolean [][] visited;
	
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	static int now_x;
	static int now_y;
	
	static Queue<Spot> q = new LinkedList<>();
	
	public static void bfs(int x, int y) {
		
		q.offer(new Spot(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			
			Spot spot = q.poll();
			
			for(int i=0; i<4; i++) {
				
				now_x = spot.x + dx[i];
				now_y = spot.y + dy[i];
				
				if((now_x >= 0 && now_x < n && now_y >= 0 && now_y < m) && 
						visited[now_x][now_y] == false && map[now_x][now_y] == 1) {
					
					q.offer(new Spot(now_x, now_y));
					visited[now_x][now_y] = true;
					
					map[now_x][now_y] = map[spot.x][spot.y] + 1;
					
					if(visited[n-1][m-1] == true) return;
				}
			}
		}
	}
	
	static class Spot{
		
		int x;
		int y;
		
		public Spot(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        
        
        
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        
        bfs(0,0);
        
        System.out.println(map[n-1][m-1]);
    }
}
