import java.util.*;

class Solution {
    
    String [] letters = {"A","E","I","O","U"};
    Map<String, Integer> map;
    
    int idx = 1;
    
    public int solution(String word) {
        int anwer = 0;
        
        map = new HashMap<>();
        dfs("", 0);
        
        return map.get(word);
    }
    
    public void dfs(String word, int len) {
        
        if(len == 5) {
            return;
        }
        
        for(int i=0; i<letters.length; i++) {
            
            map.put(word + letters[i], idx++);
            dfs(word + letters[i], len + 1);
        }
    }
}