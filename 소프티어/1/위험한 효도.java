import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int sum = 0;

        sum = 2*d + (int) (Math.ceil((double) d/a) - 1) * b + (int) (Math.ceil((double) d/b) - 1) * a;

        System.out.println(sum);
    }
}
