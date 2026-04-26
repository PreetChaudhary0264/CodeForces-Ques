import java.util.Scanner;

public class Repaint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String row0 = sc.next();
            String row1 = sc.next();

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int costV = costToMatch(row0.charAt(i - 1), row1.charAt(i - 1));
                dp[i] = dp[i - 1] + costV;
                if (i >= 2) {
                    int costH = costToMatch(row0.charAt(i - 2), row0.charAt(i - 1)) +
                            costToMatch(row1.charAt(i - 2), row1.charAt(i - 1));
                    dp[i] = Math.min(dp[i], dp[i - 2] + costH);
                }
            }
            System.out.println(dp[n]);
        }
        sc.close();
    }
    private static int costToMatch(char a, char b) {
        if (a == b) return 0;
        return 1;
    }
}