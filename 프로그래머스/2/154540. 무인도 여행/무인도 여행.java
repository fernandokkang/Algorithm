import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        
        int rows = maps.length;
        int cols = maps[0].length();
        
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> foods = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int totalFood = dfs(maps, visited, i, j);
                    foods.add(totalFood);
                }
            }
        }
        
        if (foods.isEmpty()) {
            return new int[] { -1 };
        }
        
        Collections.sort(foods);
        return foods.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dfs(String[] maps, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= maps.length || y < 0 || y >= maps[0].length() || 
            visited[x][y] || maps[x].charAt(y) == 'X') {
            return 0;
        }

        visited[x][y] = true;
        int totalFood = maps[x].charAt(y) - '0';
        
        for(int i = 0; i < 4; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            totalFood += dfs(maps, visited, nx, ny);
        }
        
        return totalFood;
    }
}