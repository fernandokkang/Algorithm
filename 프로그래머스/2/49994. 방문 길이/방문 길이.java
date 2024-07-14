import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        int x = 0, y = 0;
        Set<String> visitedPaths = new HashSet<>();

        int[] dx = {0, 0, 1, -1}; 
        int[] dy = {1, -1, 0, 0}; 
        String directions = "RLUD";

        for (char dir : dirs.toCharArray()) {
            int idx = directions.indexOf(dir);
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                String path1 = x + "" + y + "" + nx + "" + ny;
                String path2 = nx + "" + ny + "" + x + "" + y;
                
                if (!visitedPaths.contains(path1) && !visitedPaths.contains(path2)) {
                    visitedPaths.add(path1);
                    visitedPaths.add(path2);
                }
                
                x = nx;
                y = ny;
            }
        }

        return visitedPaths.size() / 2;
    }
}