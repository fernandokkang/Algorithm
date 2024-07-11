import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            
            queue.add(enemy[i]);
            
            if (queue.size() > k) {
                n -= queue.poll();
            }
                
            if (n < 0) {
                return i;
            }
        }
        
        return enemy.length;
    }
}