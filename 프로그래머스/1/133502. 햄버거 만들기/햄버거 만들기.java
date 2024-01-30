import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int idx = 0;
        
        List<Integer> hamburger = new ArrayList<>();
        
        for(int ing : ingredient) {
            
            hamburger.add(ing);
			while(hamburger.size() >= 4) {
                
				int n = hamburger.size();
				if(!(hamburger.get(n-1) == 1 && hamburger.get(n-2) == 3
					&& hamburger.get(n-3) == 2 && hamburger.get(n-4) == 1)) { 
                    break;
                }
                
				for(int i=0; i<4; i++) {
					hamburger.remove(hamburger.size()-1);
				}
				answer++;
			}
        }
        
        return answer;
    }
}