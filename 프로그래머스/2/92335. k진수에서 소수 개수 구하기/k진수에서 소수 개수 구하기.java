class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String kNum = Integer.toString(n, k);
        
        String [] parts = kNum.split("0");
        
        for(String part : parts) {
            
            if(!part.isEmpty() && isPrime(Long.parseLong(part))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long n) {
        
        if(n <= 1) {
            return false;
        }
        
        if (n == 2) {
            
            return true;
        }
        
        if(n % 2 == 0) {
            
            return false;
        }
        
        for(long i = 3; i * i <= n; i += 2) {
            
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}