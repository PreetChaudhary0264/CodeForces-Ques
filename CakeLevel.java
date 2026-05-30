import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CakeLevel {
    static class FastReaderM3 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM3() {
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
        FastReaderM3 fr = new FastReaderM3();

        int test = fr.nextInt();
        StringBuilder sb = new StringBuilder();

        while (test-- > 0) {
            int n = fr.nextInt();
            long sum = 0;
            long mh = Long.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                long a = fr.nextLong();
                sum += a;
                mh = Math.min(mh, sum / i);
                sb.append(mh).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
