import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        for(int i = 0; i<citations.length;i++) {
            
            int h_idx = citations.length - i;
            if(citations[i] >= h_idx) {
                return h_idx;
            }
        }
        
        return 0;
    }
}