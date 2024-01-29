class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            for(int j=0; j<index; j++) {
                c += 1;
                if (c > 'z') {
                    c = 'a';
                }
                if (skip.contains(String.valueOf(c))) {
                    j -= 1;
                }
            }
            
            answer += c;
        }
        
        return answer;
    }
}