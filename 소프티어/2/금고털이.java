import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] properties = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            properties[i][0] = Integer.parseInt(st.nextToken());
            properties[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(properties, (a, b) -> b[1] - a[1]);

        int profit = 0;

        for (int[] property : properties) {
            if (W > property[0]) {
                profit += property[0] * property[1];
                W -= property[0];
            } else {
                profit += W * property[1];
                break;
            }
        }

        bw.write(profit + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
