import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int day = calculateDate(today);
        
        for(String term : terms) {
            
            String [] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        
        int idx = 1;
        
        for(String privacy : privacies) {
            
            String [] s = privacy.split(" ");
            
            if (calculateDate(s[0]) + map.get(s[1]) * 28 <= day) {
                
                list.add(idx);
            }
            
            idx++;
        }
        
        return list.stream().mapToInt(Integer -> Integer).toArray();
    }
    
    private int calculateDate(String date) {
        
        String [] d = date.split("\\.");
        
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        
        return year * 12 * 28 + month * 28 + day;
    }
}