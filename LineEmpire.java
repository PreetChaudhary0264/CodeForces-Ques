import java.util.Scanner;

public class LineEmpire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            long[] x = new long[n + 1];
            x[0] = 0;

            for (int i = 1; i <= n; i++)
                x[i] = sc.nextLong();

            long[] suff = new long[n + 2];

            for (int i = n; i >= 1; i--)
                suff[i] = suff[i + 1] + x[i];

            long ans = Long.MAX_VALUE;

            for (int i = 0; i <= n; i++) {

                long cost = x[i] * (a + b)
                        + b * (suff[i + 1] - (long)(n - i) * x[i]);

                ans = Math.min(ans, cost);
            }

            System.out.println(ans);
        }
    }
}
