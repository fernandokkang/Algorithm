import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] weights = new int[N+1];

        int answer = 0;
        
        for(int i=1; i<=N; i++) {
            weights[i] = sc.nextInt();
        }

        List<Integer>[] friends = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            friends[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            friends[x].add(y);
            friends[y].add(x);
        }

        for(int i=1; i<=N; i++) {
            boolean isTop = true;
            for(int friend : friends[i]) {
                if(weights[i] <= weights[friend]) {
                    isTop = false;
                    break;
                }
            }

            if(isTop) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
