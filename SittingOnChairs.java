import java.util.*;
import java.io.*;

public class SittingOnChairs {
    public static void main(String[] args) throws IOException {
        // Using Fast Reader for 2*10^5 input size
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
            }

            // dp[i] = max chairs from index i to n
            int[] dp = new int[n + 2];

            for (int i = n; i >= 1; i--) {
                // Option 1: Skip chair i
                int skip = dp[i + 1];

                // Option 2: Sit on chair i
                // If we sit, we mark p[i].
                // If p[i] > i, the game must stop at p[i].
                // We get 1 (current) + (max chairs between i+1 and p[i]-1)
                int sit = 1;
                if (p[i] > i) {
                    // To get chairs between i+1 and p[i]-1:
                    // We take total from i+1 minus total starting from p[i]
                    sit += dp[i + 1] - dp[p[i]];
                } else {
                    // If p[i] <= i, the mark is behind us and changes nothing
                    sit += dp[i + 1];
                }

                dp[i] = Math.max(skip, sit);
            }
            System.out.println(dp[1]);
        }
    }
}
