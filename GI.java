import java.io.*;

public class GI {
    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c = read();
            while (c <= ' ') {
                if (c == -1) return Integer.MIN_VALUE;
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        for (int _case = 0; _case < t; _case++) {
            int n = fs.nextInt();

            int ans = 0;
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int ai = fs.nextInt();

                if (x > y) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }
                if (ai <= x) {
                    x = ai;
                } else if (ai <= y) {
                    y = ai;
                } else {
                    x = ai;
                    ans++;
                }
            }

            out.append(ans).append('\n');
        }
        System.out.print(out.toString());
    }
}

