import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int idx = k;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++) {
            
            char num = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < num && idx-- > 0) {
                stack.pop();
            }
            
            stack.push(num);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length() - k; i++) {
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}