import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}