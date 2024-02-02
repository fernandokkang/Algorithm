import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> tanList = new ArrayList<>(map.values());
        Collections.sort(tanList, Collections.reverseOrder());
        
        for(int tan : tanList) {
            
            answer++;
            
            if(sum + tan >= k) {
                break;
            }
            
            sum += tan;
        }
        
        return answer;
    }
}