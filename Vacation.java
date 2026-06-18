import java.util.*;

public class Vacation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[n][3];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (i == 0) {
                dp[0][0] = a;
                dp[0][1] = b;
                dp[0][2] = c;
                continue;
            }

            dp[i][0] = a + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = b + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = c + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(
                Math.max(dp[n - 1][0],
                        Math.max(dp[n - 1][1], dp[n - 1][2]))
        );
    }
}
