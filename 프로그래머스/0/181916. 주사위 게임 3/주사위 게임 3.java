import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1);
        frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        frequencyMap.put(d, frequencyMap.getOrDefault(d, 0) + 1);

        int score = 0;
        
        if (frequencyMap.size() == 1) {
            
            int p = a;
            score = 1111 * p;
        } else if (frequencyMap.size() == 2) {
            
            int[] values = new int[2];
            int idx = 0;
            for (int key : frequencyMap.keySet()) {
                values[idx++] = key;
            }
            int p = values[0];
            int q = values[1];
            if (frequencyMap.get(p) == 3 || frequencyMap.get(q) == 3) {
                if (frequencyMap.get(p) == 3) {
                    score = (int) Math.pow(10 * p + q, 2);
                } else {
                    score = (int) Math.pow(10 * q + p, 2);
                }
            } else {
                // 주사위 두 개씩 같은 값이 나온 경우
                score = (p + q) * Math.abs(p - q);
            }
        } else if (frequencyMap.size() == 3) {
            
            int[] values = new int[3];
            int idx = 0;
            for (int key : frequencyMap.keySet()) {
                values[idx++] = key;
            }
            int p = 0, q = 0, r = 0;
            for (int key : frequencyMap.keySet()) {
                if (frequencyMap.get(key) == 2) {
                    p = key;
                } else if (q == 0) {
                    q = key;
                } else {
                    r = key;
                }
            }
            score = q * r;
        } else {
            
            int min = Math.min(Math.min(a, b), Math.min(c, d));
            score = min;
        }
        
        return score;
    }
}