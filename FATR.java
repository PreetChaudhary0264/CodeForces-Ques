import java.io.*;
import java.util.*;

public class FATR {
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

        int nextInt() {
            try {
                int c = read();
                while (c <= ' ' && c >= 0) c = read();
                int sign = 1;
                if (c == '-') { sign = -1; c = read(); }
                int val = 0;
                while (c > ' ') {
                    val = val * 10 + (c - '0');
                    c = read();
                }
                return val * sign;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void removeOne(TreeMap<Integer, Integer> ms, int key) {
        int cnt = ms.get(key);
        if (cnt == 1) ms.remove(key);
        else ms.put(key, cnt - 1);
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) x[i] = fs.nextInt();
            for (int i = 0; i < n; i++) y[i] = fs.nextInt();

            TreeMap<Integer, Integer> ms = new TreeMap<>();
            long total = 0;
            for (int i = 0; i < n; i++) {
                int diff = y[i] - x[i];
                ms.put(diff, ms.getOrDefault(diff, 0) + 1);
                total++;
            }

            int ans = 0;
            while (total > 1) {
                int val1 = ms.firstKey();
                removeOne(ms, val1);
                total--;

                Integer partner = ms.ceilingKey(-val1);
                if (partner == null) continue;

                removeOne(ms, partner);
                total--;
                ans++;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
