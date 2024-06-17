import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            pq.add(work);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            
            int max = pq.poll();
            
            if(max > 0) {
                pq.add(max - 1);
            }
            
            n--;
        }
        
        while(!pq.isEmpty()) {
            
            int remainingWork = pq.poll();
            
            answer += remainingWork * remainingWork;
        }
        
        return answer;
    }
}