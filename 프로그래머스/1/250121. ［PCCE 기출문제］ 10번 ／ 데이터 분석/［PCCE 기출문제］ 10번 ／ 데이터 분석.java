import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extIndex = getIndex(ext);
        int sortByIndex = getIndex(sort_by);
        
        List<int[]> datas = new ArrayList<>();
        
        for(int[] item : data) {
            if(item[extIndex] < val_ext) {
                datas.add(item);
            }
        }
        
        datas.sort((a, b) -> Integer.compare(a[sortByIndex], b[sortByIndex]));
            
        return datas;
    }
    
    private int getIndex(String query) {
        
        if(query.equals("code")) {
            return 0;
        }
        
        else if(query.equals("date")) {
            return 1;
        }
        
        else if(query.equals("maximum")) {
            return 2;
        }
        
        else {
            return 3;
        }
    }
}