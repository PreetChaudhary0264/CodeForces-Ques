import java.util.Scanner;

public class Convergence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int t = a[i];
                int lc = 0;
                int rc = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j] < t) {
                        lc++;
                    } else if (a[j] > t) {
                        rc++;
                    }
                }
                int currentCalls = Math.max(lc, rc);
                if (currentCalls < ans) {
                    ans = currentCalls;
                }
            }
            System.out.println(ans);
        }
    }
}
