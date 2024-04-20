import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();

        int[] start = new int[2];
        int[] escape = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                }

                if (maps[i].charAt(j) == 'E') {
                    escape = new int[]{i, j};
                }

                if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
        
        int dist1 = bfs(maps, start, lever);
        int dist2 = bfs(maps, lever, escape);
        
        return (dist1 == -1 || dist2 == -1) ? -1 : dist1 + dist2;
    }
    
    private int bfs(String[] maps, int[] start, int[] target) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean [][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {

            int[] point = queue.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];
            int nx, ny;

            if (x == target[0] && y == target[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {

                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X' || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}