class Solution {
    
    boolean [] visited;
    int max;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
                
        return max;
    }
    
    private void dfs(int[][] dungeons, int current, int count) {
        
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            
            if(!visited[i] && current >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, current - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}