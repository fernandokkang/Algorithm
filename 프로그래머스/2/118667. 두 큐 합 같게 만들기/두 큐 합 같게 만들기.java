import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;
        
        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;
        long targetSum = totalSum / 2;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : queue1) q1.offer(num);
        for (int num : queue2) q2.offer(num);
        
        int maxOperations = queue1.length + queue2.length;
        int answer = 0;
        
        while (sum1 != targetSum) {
            if (answer > maxOperations * 2) return -1;
            
            if (sum1 > targetSum) {
                int val = q1.poll();
                sum1 -= val;
                q2.offer(val);
                sum2 += val;
            } else {
                int val = q2.poll();
                sum2 -= val;
                q1.offer(val);
                sum1 += val;
            }
            answer++;
        }
        
        return answer;
    }
}