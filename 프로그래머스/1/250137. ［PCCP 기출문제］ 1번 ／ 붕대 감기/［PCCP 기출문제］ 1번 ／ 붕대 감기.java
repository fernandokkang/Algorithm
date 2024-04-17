class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int a_idx = 0;
        int h_idx = 0;
        int max = health;
        
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            
            if(attacks[a_idx][0] == i) {
                
                health -= attacks[a_idx][1];
                if(health <= 0) {
                    return -1;
                }
                
                a_idx++;
                h_idx = 0;
                continue;
            }
            
            health += bandage[1];
            h_idx++;
            
            if(bandage[0] == h_idx) {
                
                health += bandage[2];
                h_idx = 0;
            }
            
            if(health > max) {
                health = max;
            }
        }
        
        return health;
    }
}