import java.util.*;

public class S {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder op = new StringBuilder();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];

            for (int i = 0; i < n; i++) x[i] = sc.nextInt();
            for (int i = 0; i < n; i++) y[i] = sc.nextInt();

            op.append(run(n, x, y)).append("\n");
        }

        System.out.print(op);
    }

    static long run(int n, int[] x, int[] y) {
        boolean[] vis = new boolean[n + 1];
        long res = 0;

        for (int i = 0; i < n; i++) {
            int p = lb(y, x[i]);
            if (p < 0) return -1;

            int ch = pick(vis, p, n);
            if (ch == -1) return -1;

            res += count(vis, ch);
            vis[ch] = true;
        }

        return res;
    }

    static int lb(int[] a, int v) {
        int l = 0, r = a.length - 1, ans = -1;

        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] >= v) {
                ans = m + 1;
                r = m - 1;
            } else l = m + 1;
        }

        return ans;
    }

    static int pick(boolean[] vis, int p, int n) {
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && i >= p) return i;
        }
        return -1;
    }

    static int count(boolean[] vis, int ch) {
        int c = 0;
        for (int i = 1; i < ch; i++) if (!vis[i]) c++;
        return c;
    }
}