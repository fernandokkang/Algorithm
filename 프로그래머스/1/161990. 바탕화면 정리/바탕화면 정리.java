import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < lux) lux = i;
                    if (j < luy) luy = j;
                    if (i > rdx) rdx = i;
                    if (j > rdy) rdy = j;
                }
            }
        }
        
        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}