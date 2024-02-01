class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        
        if(x % y == 0) {
            return y;
        }
        
        return gcd(y, x % y);
    }
    
    public int lcm(int a, int b){
        
        return a * b / gcd(a, b);
    }
}