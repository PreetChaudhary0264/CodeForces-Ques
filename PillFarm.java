import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PillFarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
            long s = 0;
            long maxScore = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                if (i >= m - 1) {
                    long currentScore = (long) m * arr[i] - s;
                    if (currentScore > maxScore) {
                        maxScore = currentScore;
                    }
                }
                pq.add(arr[i]);
                s += arr[i];
                if (pq.size() > m - 1) {
                    s -= pq.poll();
                }
            }
            System.out.println(maxScore);
        }
    }
}
