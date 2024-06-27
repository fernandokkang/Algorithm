import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [][] time = new int[N][2];

        for(int i=0; i<N; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, (a, b) -> a[1] - b[1]);

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (time[i][0] >= endTime) {
                count++;
                endTime = time[i][1];
            }
        }

        System.out.println(count);
    }
}
