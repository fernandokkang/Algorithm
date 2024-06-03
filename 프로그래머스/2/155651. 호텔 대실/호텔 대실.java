import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int [] time = new int[1440];
        
        for(int i=0; i<book_time.length; i++){
            
            String [] st = book_time[i][0].split(":");
            String [] et = book_time[i][1].split(":");
            
            int startTime = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
            int endTime = Integer.parseInt(et[0]) * 60 + Integer.parseInt(et[1]);
                        
            for(int j = startTime; j < endTime + 10; j++){
                
                if(j >= 1440) {
                    break;
                }
                
                time[j] += 1;
            }
        }
        
        Arrays.sort(time);
        
        answer = time[time.length - 1];
        
        return answer;
    }
}