import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days++;
            }
            queue.add(days);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int currentReleaseDay = queue.poll();
        int count = 1;  
        
        while (!queue.isEmpty()) {
            int nextReleaseDay = queue.poll();
            if (nextReleaseDay <= currentReleaseDay) {
                count++;
            } else {
                result.add(count);
                currentReleaseDay = nextReleaseDay;
                count = 1;
            }
        }
        
        result.add(count);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}