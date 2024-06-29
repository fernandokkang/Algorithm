import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] answer = new int[N];
        
        int[][] tmp = new int[N + 1][2];
        double[] failure = new double[N];
        
        for (int stage : stages) {
            if (stage < N + 1) tmp[stage][0]++;
        }
        
        tmp[1][1] = stages.length;
        
        for (int i = 2; i < tmp.length; i++) {
            tmp[i][1] = tmp[i - 1][1] - tmp[i - 1][0];
        }
        
        for (int i = 0; i < failure.length; i++) {
            if (tmp[i + 1][1] != 0) {
                failure[i] = (double) tmp[i + 1][0] / tmp[i + 1][1];
            } else {
                failure[i] = 0;
            }
        }
        
        List<int[]> failureList = new ArrayList<>();
        for (int i = 0; i < failure.length; i++) {
            failureList.add(new int[]{i + 1, Double.compare(failure[i], 0)});
        }
        
        failureList.sort((a, b) -> {
            double diff = failure[b[0] - 1] - failure[a[0] - 1];
            if (diff == 0) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Double.compare(failure[b[0] - 1], failure[a[0] - 1]);
            }
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = failureList.get(i)[0];
        }
        
        return answer;
    }
}