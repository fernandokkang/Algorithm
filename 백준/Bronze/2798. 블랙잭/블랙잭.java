import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int [] cards = new int[N];
        
        for(int i=0; i<N; i++) {
            cards[i] = sc.nextInt();
        }
        
        System.out.println(solution(cards, N, M));
    }
    
    static int solution(int [] cards, int N, int M) {
        
        int answer = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    int tmp = cards[i] + cards[j] + cards[k];
                    
                    if(M == tmp) {
                        return tmp;
                    }
                    
                    if(answer < tmp && tmp < M) {
                        answer = tmp;
                    }
                }
            }
        }
        
        return answer;
    }
}