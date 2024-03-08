import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            StringBuilder str = new StringBuilder(s);
            String rotation = s.substring(0, i);
            str.delete(0, i);
            str.append(rotation);
 
            if(isCorrect(str.toString())){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isCorrect(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            
                continue;
            }
            
            if((s.charAt(i) == '}' && stack.peek() == '{')
                || (s.charAt(i) == ']' && stack.peek() == '[')
                || (s.charAt(i) == ')' && stack.peek() == '(')) {
                stack.pop();
            } else{
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}