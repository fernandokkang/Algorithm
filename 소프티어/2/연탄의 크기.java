import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] briquette = new int[n];

        for(int i=0; i<n; i++) {
            briquette[i] = sc.nextInt();
        }

        int max = 1;
        
        for(int i=2; i<100; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(briquette[j] % i == 0) {
                    cnt++;
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);
    }
}
