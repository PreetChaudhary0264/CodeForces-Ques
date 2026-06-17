import java.io.*;

public class IdiotFirstSearch {

    static final long MOD = 1000000007L;

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

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

    static int[][] tree;
    static int[] nodes;
    static int[] parent;
    static long[] ans;

    static int calculateNodes(int u) {
        if (tree[u][0] == 0 && tree[u][1] == 0) {
            return 1;
        }

        nodes[u] = calculateNodes(tree[u][0]) + calculateNodes(tree[u][1]);
        return nodes[u] + 1;
    }

    static void solve(int u) {
        int p = parent[u];

        ans[u] = (ans[p] + 2L * nodes[u] + 1) % MOD;

        if (tree[u][0] != 0) solve(tree[u][0]);
        if (tree[u][1] != 0) solve(tree[u][1]);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            int n = fs.nextInt();

            tree = new int[n + 1][2];
            nodes = new int[n + 1];
            parent = new int[n + 1];
            ans = new long[n + 1];

            parent[1] = 0;

            for (int i = 1; i <= n; i++) {
                int l = fs.nextInt();
                int r = fs.nextInt();

                tree[i][0] = l;
                tree[i][1] = r;

                if (l != 0) parent[l] = i;
                if (r != 0) parent[r] = i;
            }

            calculateNodes(1);
            solve(1);

            for (int i = 1; i <= n; i++) {
                out.append(ans[i]).append(' ');
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}