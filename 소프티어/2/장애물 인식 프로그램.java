import java.io.*;
import java.util.*;

public class Main {

    static boolean [][] visited;
    static int [][] map;

    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    static int N;
    static int cnt;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {

            String s = sc.next();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                
                cnt = 1;
                dfs(i, j);
                list.add(cnt); 
            }
        }

        Collections.sort(list);
        
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0 || visited[nx][ny]) continue;
                
            cnt++;
            dfs(nx, ny);
        }
    }
}
