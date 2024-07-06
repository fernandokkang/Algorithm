import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int length = friends.length;
        
        Map<String, Integer> friendsId = new HashMap<>();
        int[][] giftChart = new int[length][length];
        int[] given = new int[length];
        int[] received = new int[length];
        
        for(int i=0; i<length; i++) {
            
            friendsId.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            
            String[] s = gift.split(" ");
            int giver = friendsId.get(s[0]);
            int receiver = friendsId.get(s[1]);
            giftChart[giver][receiver]++;
            given[giver]++;
            received[receiver]++;
        }
        
        int[] giftReceivedNextMonth = new int[length];
        
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (i == j) continue;                
                if (giftChart[i][j] > giftChart[j][i]) {
                    giftReceivedNextMonth[i]++;
                } else if (giftChart[i][j] < giftChart[j][i]) {
                    giftReceivedNextMonth[j]++;
                } else {
                    int giftIndexI = given[i] - received[i];
                    int giftIndexJ = given[j] - received[j];
                    
                    if (giftIndexI > giftIndexJ) {
                        giftReceivedNextMonth[i]++;
                    } else if (giftIndexI < giftIndexJ) {
                        giftReceivedNextMonth[j]++;
                    }
                }
            }
        }
        
        for (int count : giftReceivedNextMonth) {
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}