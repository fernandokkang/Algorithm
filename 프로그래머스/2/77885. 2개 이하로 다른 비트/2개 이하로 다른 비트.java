class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            
            answer[i] = f(numbers[i]);
        }
        
        return answer;
    }
    
    private long f(long x) {
        if (x % 2 == 0) {
            return x + 1;
        }
       
        long bit = 1;
        while ((x & bit) != 0) {
            bit <<= 1;
        }
        return (x | bit) & ~(bit >> 1);
    }
}