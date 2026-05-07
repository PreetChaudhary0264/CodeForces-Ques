import java.util.*;
import java.io.*;

public class DiceRolls {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] dp = new int[7];
            final int INF = 1_000_000_000;

            for (int v = 1; v <= 6; v++) {
                dp[v] = (a[0] == v) ? 0 : 1;
            }

            for (int i = 1; i < n; i++) {
                int[] nextDp = new int[7];
                int currentVal = a[i];

                for (int v = 1; v <= 6; v++) {
                    int minPrev = INF;
                    for (int u = 1; u <= 6; u++) {
                        if (u != v && u + v != 7) {
                            minPrev = Math.min(minPrev, dp[u]);
                        }
                    }

                    nextDp[v] = minPrev + (currentVal == v ? 0 : 1);
                }
                dp = nextDp;
            }

            int ans = INF;
            for (int v = 1; v <= 6; v++) {
                ans = Math.min(ans, dp[v]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
