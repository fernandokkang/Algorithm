import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        answer = sb.toString();
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}