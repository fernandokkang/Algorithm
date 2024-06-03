class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        
        int[][] triangle = new int[n][n];
        
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        
        int num = 1;
        int row = 0, col = 0;
        int dir = 0;
        
        for(int i = 0; i < n * (n + 1) / 2; i++) {
            
            triangle[row][col] = num++;
            
            int nr = row + dr[dir];
            int nc = col + dc[dir];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || triangle[nr][nc] != 0) {
                dir = (dir + 1) % 3;
                nr = row + dr[dir];
                nc = col + dc[dir];
            }
            
            row = nr;
            col = nc;
        }
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}