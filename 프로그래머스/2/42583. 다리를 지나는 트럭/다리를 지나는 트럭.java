import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new LinkedList<>();
        int bridgeWeight = 0;
        int truckIndex = 0;
        int answer = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        while (!bridge.isEmpty()) {
            answer++;
            bridgeWeight -= bridge.poll();

            if (truckIndex < truck_weights.length) {
                if (bridgeWeight + truck_weights[truckIndex] <= weight) {

                    bridge.add(truck_weights[truckIndex]);
                    bridgeWeight += truck_weights[truckIndex];
                    truckIndex++;
                } else {
                    bridge.add(0);
                }
            }
        }
        
        return answer;
    }
}