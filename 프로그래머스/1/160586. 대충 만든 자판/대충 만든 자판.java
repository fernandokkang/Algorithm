import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                
                char key = keymap[i].charAt(j);
                
                if(map.containsKey(key)) {
                    map.put(key, Math.min(map.get(key), j+1));
                }else {
                    map.put(key, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            for(int j=0; j<targets[i].length(); j++) {
                
                char target = targets[i].charAt(j);
                
                if(map.containsKey(target)) {
                    answer[i] += map.get(target);
                }else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}