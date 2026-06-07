import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PTATT {
    static class FastReaderM7 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM7() {
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
        FastReaderM7 fr = new FastReaderM7();
        StringBuilder ans = new StringBuilder();

        int test = fr.nextInt();

        while (test-- > 0) {
            long n = fr.nextLong();

            if (n == 10) {
                ans.append("-1\n");
                continue;
            }

            long rem = n % 12;
            long first;

            if (rem == 10) {
                first = 22;
            } else if (rem == 11) {
                first = 11;
            } else {
                first = rem;
            }

            long second = n - first;

            ans.append(first).append(" ").append(second).append("\n");
        }
        System.out.println(ans);
    }
}
