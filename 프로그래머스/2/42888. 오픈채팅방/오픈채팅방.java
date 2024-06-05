import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> userLog = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (String entry : record) {
            
            String[] parts = entry.split(" ");
            String action = parts[0];
            String userId = parts[1];
            
            if (action.equals("Enter") || action.equals("Change")) {
                
                String nickname = parts[2];
                userLog.put(userId, nickname);
            }
        }
        
        for (String entry : record) {
            
            String [] parts = entry.split(" ");
            String action = parts[0];
            String userId = parts[1];
            
            if (action.equals("Enter")) {
                result.add(userLog.get(userId) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                result.add(userLog.get(userId) + "님이 나갔습니다.");
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}