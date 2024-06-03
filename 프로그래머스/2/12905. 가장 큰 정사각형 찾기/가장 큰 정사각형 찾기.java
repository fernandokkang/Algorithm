class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n][m];
        int maxSide = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = board[i][j];
                
                if (i == 0 || j == 0) {
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        int maxSquareArea = maxSide * maxSide;
        return maxSquareArea;
    }
}