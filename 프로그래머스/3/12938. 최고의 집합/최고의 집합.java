import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (s < n) {
            return new int[] {-1};
        }
        
        Arrays.fill(answer, s / n);
        
        int remainder = s % n;
        
        for(int i = 0; i < remainder; i++) {
            answer[n - 1 - i]++;
        }
        
        return answer;
    }
}