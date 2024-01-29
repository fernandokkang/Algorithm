class Solution {
    public int solution(int a, int b, boolean flag) {
        int answer = a - b;
        
        if(flag) {
            return a + b;
        }
        
        return answer;
    }
}