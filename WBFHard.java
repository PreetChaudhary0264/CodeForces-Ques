import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WBFHard {

    static class FastReaderWBFHard {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderWBFHard() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastReaderWBFHard sc = new FastReaderWBFHard();
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long[][] dp = new long[n][2];
            int[][] ops = new int[n][2];
            dp[0][0] = a[0];
            dp[0][1] = -a[0];
            long MIN_VAL = (long) -1e18;

            for (int i = 1; i < n; i++) {
                long val1 = a[i];
                dp[i][0] = dp[i - 1][0] + val1;
                long o1 = MIN_VAL;
                if (val1 > 0) {
                    o1 = dp[i - 1][1] - val1;
                }
                if (o1 > dp[i][0]) {
                    dp[i][0] = o1;
                    ops[i][0] = 1;
                }
                long val2 = -a[i];
                dp[i][1] = dp[i - 1][1] + val2;
                long o2 = MIN_VAL;
                if (val2 > 0) {
                    o2 = dp[i - 1][0] - val2;
                }
                if (o2 > dp[i][1]) {
                    dp[i][1] = o2;
                    ops[i][1] = 1;
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            int currState = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (ops[i][currState] == 1) {
                    ans.add(i + 1);
                    currState = 1 - currState;
                }
            }
            System.out.println(ans.size());
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + (i == ans.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}
