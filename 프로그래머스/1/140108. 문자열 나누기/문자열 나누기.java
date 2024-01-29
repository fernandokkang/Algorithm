class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int [] comp = {0,0};
        
        for(int i=0; i<s.length(); i++) {
            
            if(x == s.charAt(i)) {
                comp[0]++;
            }else {
                comp[1]++;
            }
            
            if(comp[0] == comp[1]) {
                answer++;
                comp[0] = 0;
                comp[1] = 0;
                
                if(i+1 < s.length()) {
                    x = s.charAt(i+1);
                }
            }else if(i == s.length() - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}