import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int min_idx = 0;
        int max_idx = people.length - 1;
        
        while(min_idx <= max_idx) {
            
            answer++;
            
            if(people[min_idx] + people[max_idx] <= limit) {
                
                min_idx++;
                max_idx--;
                
                continue;
            }
            
            max_idx--;
        }
        
        return answer;
    }
}