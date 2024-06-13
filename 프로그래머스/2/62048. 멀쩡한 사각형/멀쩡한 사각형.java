class Solution {
    public long solution(int w, int h) {
        
        long total = (long) w * h;
        
        return total - (w + h - gcd(w, h));
    }
    
    private int gcd(int a, int b) {
        
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}