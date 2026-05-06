import java.util.*;

public class FlowerBoy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            // ---------------- PREFIX ----------------
            int[] pref = new int[m];
            int j = 0;

            for (int i = 0; i < m; i++) {
                while (j < n && a[j] < b[i]) j++;

                if (j == n) {
                    pref[i] = n;
                } else {
                    pref[i] = j;
                    j++;
                }
            }

            // If already possible without insertion
            if (pref[m - 1] < n) {
                System.out.println(0);
                continue;
            }

            // ---------------- SUFFIX ----------------
            int[] suff = new int[m];
            j = n - 1;

            for (int i = m - 1; i >= 0; i--) {
                while (j >= 0 && a[j] < b[i]) j--;

                if (j < 0) {
                    suff[i] = -1;
                } else {
                    suff[i] = j;
                    j--;
                }
            }

            // ---------------- TRY DELETE ONE ----------------
            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++) {

                int left = (i == 0) ? -1 : pref[i - 1];
                int right = (i == m - 1) ? n : suff[i + 1];

                if (left < right) {
                    ans = Math.min(ans, b[i]);
                }
            }

            if (ans == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(ans);
        }
    }
}
