import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.target;
            int currentTime = currentNode.time;
            
            if (currentTime > dist[current]) {
                continue;
            }
            
            for (Node neighbor : graph.get(current)) {
                int newTime = currentTime + neighbor.time;
                if (newTime < dist[neighbor.target]) {
                    dist[neighbor.target] = newTime;
                    pq.offer(new Node(neighbor.target, newTime));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static class Node {
    
        int target;
        int time;

        Node(int target, int time) {
            this.target = target;
            this.time = time;
        }
    }   
}