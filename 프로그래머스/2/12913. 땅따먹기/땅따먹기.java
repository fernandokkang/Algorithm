class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int [][] dp = new int[land.length][4];
        
        for(int i=0; i<land.length; i++) {
            if(i == 0) {
                dp[i][0] = land[i][0];
                dp[i][1] = land[i][1];
                dp[i][2] = land[i][2];
                dp[i][3] = land[i][3];
                
                continue;
            }
            
            dp[i][0] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][3];
        }

        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        return answer;
    }
}