import java.io.*;
import java.util.*;

public class StrangeBirthDayParty {

    static class FastReaderM {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws Exception {

        FastReaderM sc = new FastReaderM();
        StringBuilder sb = new StringBuilder();

        int test = sc.nextInt();

        while (test-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] k = new int[n];

            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
            }

            long[] c = new long[m];

            for (int i = 0; i < m; i++) {
                c[i] = sc.nextLong();
            }

            Arrays.sort(k);

            int idx = 0;
            long cost = 0;

            for (int i = n - 1; i >= 0; i--) {

                if (idx < m && c[idx] <= c[k[i] - 1]) {
                    cost += c[idx];
                    idx++;
                } else {
                    cost += c[k[i] - 1];
                }
            }

            sb.append(cost).append('\n');
        }

        System.out.print(sb);
    }
}
