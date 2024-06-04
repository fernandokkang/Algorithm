import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String [] str = s.split("");
        
        int idx = 0;
        
        for(int i = 0; i < str.length; i++) {
            
            if(str[i].equals(" ")) {
                idx = 0;
                answer += " ";
                continue;
            }
                       
            answer += idx++ % 2 == 0 ? str[i].toUpperCase() : str[i].toLowerCase();
        }
        
        return answer;
    }
}