import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int match = 0;
        int zeroCnt = 0;
        
        for(int i=0; i<6; i++) {
            
            if(lottos[i] == 0) {
                zeroCnt++;
            }
            
            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j]) {
                    match++;
                }
            }
        }
        
        answer[0] = Math.min(7 - (match + zeroCnt), 6);
        answer[1] = Math.min(7 - match, 6);
        
        return answer;
    }
}