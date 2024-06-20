import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() < t * m) {
            
            String number = Integer.toString(num++, n).toUpperCase();
            sb.append(number);
        }
        
        String str = sb.substring(0, t * m);
        
        for(int i = p-1; i < str.length(); i += m) {
            
            answer.append(str.charAt(i));
        }
        
        return answer.toString();
    }
}