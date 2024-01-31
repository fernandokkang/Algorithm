class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int sum = brown + yellow;
        
        for(int i = 3; i < sum / 2; i++) {
            
            int j = sum / i;
            
            if(sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                
                if((col - 2) * (row - 2) == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    
                    return answer;
                }
            }
        }
        
        return answer;
    }
}