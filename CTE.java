import java.io.*;
import java.util.*;

public class CTE {
    static long[] se = new long[10000000];
    static int b(long x, int idx) {
        int m = 0;
        do {
            se[idx++] = (x << 32) | m;
            if (x == 1) {
                if (m == 0) {
                    se[idx++] = (2L << 32) | 1;
                }
                return idx;
            }
            m++;
            if ((x & 1) != 0) {
                x = x + 1;
            } else {
                x = x >> 1;
            }
        } while (true);
    }

    public static void main(String[] args) throws Exception {
        FastReaderM fs = new FastReaderM();
        StringBuilder ans = new StringBuilder();
        int test = fs.nextInt();
        while (test-- > 0) {
            int n = fs.nextInt();
            int size = 0;
            for (int i = 0; i < n; i++) {
                long num = fs.nextLong();
                size = b(num, size);
            }
            Arrays.sort(se, 0, size);
            long best = Long.MAX_VALUE;
            int ptr = 0;
            do {
                long current = se[ptr] >>> 32;
                long total = 0;
                int freq = 0;
                do {
                    total += (se[ptr] & 0xFFFFFFFFL);
                    freq++;
                    ptr++;
                }
                while (ptr < size && (se[ptr] >>> 32) == current);
                if (freq == n && total < best) {
                    best = total;
                }
            } while (ptr < size);
            ans.append(best).append('\n');
        }
        System.out.print(ans);
    }
}
class FastReaderM {
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
