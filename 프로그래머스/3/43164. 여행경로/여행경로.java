import java.util.*;

class Solution {
    
    List<String> list;
    boolean [] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(String depart, String arrive, String[][] tickets, int depth) {
        
        if(tickets.length == depth) {
            
            list.add(arrive);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && depart.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], arrive+" "+tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}