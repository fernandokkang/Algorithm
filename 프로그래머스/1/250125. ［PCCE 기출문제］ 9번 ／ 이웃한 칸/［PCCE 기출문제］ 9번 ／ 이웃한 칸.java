class Solution {
    
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                continue;
            }
            
            if(board[nx][ny].equals(color)) {
                answer++;
            }
        }   
        
        return answer;
    }
}