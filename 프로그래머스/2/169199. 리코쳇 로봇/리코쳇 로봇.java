import java.util.*;

class Solution {
    
    String[][] map;
    int[][] visited;
    
    Queue<int[]> q;
    
    int[] dx = {1, -1, 0, 0}; 
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        map = new String[n][m];
        visited = new int[n][m];
        
        int startX = 0, startY = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY, n, m);
    }
    
    private int bfs(int startX, int startY, int n, int m) {
        q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int steps = visited[x][y];
            
            if (map[x][y].equals("G")) {
                return steps - 1;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;
                
                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    
                    if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty].equals("D")) {
                        break;
                    }
                    
                    nx = tx;
                    ny = ty;
                }
                
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = steps + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    
        return -1;
    }
}
