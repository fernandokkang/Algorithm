import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for(String player : callings) {
            
            int playerRank = rank.get(player);
            String previous = players[playerRank-1];
            
            rank.replace(previous, playerRank);
            players[playerRank] = previous;
            
            rank.replace(player, playerRank-1);
            players[playerRank-1] = player;
        }
        
        return players;
    }
}
