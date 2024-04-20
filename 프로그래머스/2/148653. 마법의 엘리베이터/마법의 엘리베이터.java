class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            
            int digit_one = storey % 10;
            int digit_ten = storey / 10 % 10;
            
            if (digit_one > 5) {
                answer += (10 - digit_one);
                storey += (10 - digit_one);
            } else if (digit_one == 5) {
                answer += 5;
                storey += digit_ten < 5 ? -5 : 5;
            } else {
                answer += digit_one;
                storey -= digit_one;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}