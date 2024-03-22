import java.util.*;

class Solution {
    
    static int answer = -1;
    
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int visited[][];
    
    public int solution(int[][] maps) {

        visited = new int[maps.length][maps[0].length];
        
        return bfs(0, 0, maps);
    }
    
    private int bfs(int x, int y, int [][] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        
        while(!q.isEmpty()) {
        
            int [] current = q.poll();
            int X = current[0];
            int Y = current[1];
            
            for(int i=0; i<4; i++) {
                
                int nX = X + dx[i];
                int nY = Y + dy[i];
                
                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
                    continue;
                }
                
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    
                    visited[nX][nY] = visited[X][Y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }

        
        return visited[maps.length - 1][maps[0].length - 1] != 0 ? 
            visited[maps.length - 1][maps[0].length - 1] : -1;
    }
}