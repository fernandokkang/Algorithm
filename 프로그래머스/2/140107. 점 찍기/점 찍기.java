class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long max = (long) d * d;
        
        for(int i = 0; i <= d; i += k) {
            
            answer += (int) (Math.sqrt(max - (long) i * i) / k) + 1;
        }
        
        return answer;
    }
}