import java.util.*;

public class RaeTaylorAndTrees {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();

        int[] p = new int[n + 1];
        int[] pre = new int[n + 1];
        int[] suf = new int[n + 2];
        pre[0] = n;
        suf[n + 1] = 0;

        // input + prefix min
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            pre[i] = Math.min(pre[i - 1], p[i]);
        }

        // suffix max
        for (int i = n; i >= 1; i--) {
            suf[i] = Math.max(suf[i + 1], p[i]);
        }

        // check condition
        for (int i = 2; i <= n; i++) {
            if (pre[i - 1] > suf[i]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}