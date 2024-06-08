import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.add(scov);
        }
        
        while (pq.peek() < K) {
            
            if (pq.size() < 2) {
                return -1; 
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second * 2);
            pq.add(newScoville);
            answer++;
        }
        
        return answer;
    }
}