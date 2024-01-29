class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            if(divisorCount(i) <= limit){
                answer += divisorCount(i);
            }else{
                answer += power;
            }
        }
        
        return answer;
    }
    
    public int divisorCount(int n) {
        
        int count = 0;
        
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i == Math.sqrt(n)) {
                count++;
            }else if(n % i == 0) {
                count += 2;
            }
        }
        
        return count;
    }
}