import java.util.PriorityQueue;
import java.util.Scanner;

public class Cyclists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int m = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(sc.nextInt());
            }
            int win = 0;
            while(m > 0){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                int l = 0;
                int r = 0;
                while(r < n){
                    if(r == p){
                        m -= sb.charAt(r) - '0';
                        sb.append(sb.charAt(r));
                        sb.deleteCharAt(r);
                        win++;
                        if(r == n-1)break;
                    }
                    if(m < 0)break;
                    int num = sb.charAt(r) - '0';
                    pq.add(num);
                    if(r-l+1 == k){
                        int min = pq.peek();
                        m -= min;
                        pq.remove();
                    }
                    r++;
                }
            }
        }
    }
}
