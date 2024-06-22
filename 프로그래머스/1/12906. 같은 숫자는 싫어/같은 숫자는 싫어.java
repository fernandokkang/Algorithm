import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr) {
            
            if(stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
                list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}