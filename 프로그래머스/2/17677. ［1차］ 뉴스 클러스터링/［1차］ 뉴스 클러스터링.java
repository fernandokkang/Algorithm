import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> list1 = makeSet(str1);
        List<String> list2 = makeSet(str2);
        
        List<String> intersection = new ArrayList<>();
        List<String> union = list1;
        
        for(String s : list1) {
            if(list2.contains(s)) {
                intersection.add(s);
                list2.remove(s);
            }
        }
        
        union.addAll(list2);
        
        if(union.size() == 0) {
            
            return 65536;
        }
        
        double jacquard = intersection.size() / (double) union.size();
        
        return (int) (jacquard * 65536);
    }
    
    private List<String> makeSet(String str) {
        
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        
        for(int i=0; i<str.length() - 1; i++) {
            
            String s = str.substring(i, i+2).replaceAll("[^a-z]", "");
            
            if(s.length() == 2) {
                list.add(s);
            }
        }
        
        return list;
    }
}