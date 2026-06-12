import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OmskProgrammers {
    static long MOD = (long) 1e9 + 7;
    static long[] bit;
    static int n;

    static class FastReaderM2 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM2() {
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

    private static long powerExpo(long a, long b) {
        if (b == 0) return 1;
        long half = powerExpo(a, b / 2);
        long res = (half * half) % MOD;

        if (b % 2 != 0) {
            res = (a * res) % MOD;
        }
        return res;
    }

    private static int[][] buildSparse(int[] arr) {
        int maxLog = 1;
        int n = arr.length;
        while ((1 << maxLog) <= n) maxLog++;
        int[][] st = new int[maxLog][n];
        //base case => for length 1 startign from each index

        for (int i = 0; i < n; i++) {
            st[0][i] = arr[i];
        }
        for (int k = 1; k < maxLog; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                st[k][i] = Math.max(
                        st[k - 1][i],
                        st[k - 1][i + (1 << (k - 1))]
                );
            }
        }
        return st;
    }

    private static int querySparse(int l, int r, int[][] st) {
        int len = r - l + 1;

//        int k = 31 - Integer.numberOfLeadingZeros(len);      //int k = log2(len);

        int k = (int) (Math.log(len) / Math.log(2));

        return Math.max(
                st[k][l],
                st[k][r - (1 << k) + 1]
        );
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static long modInverse(long a, long mod) {
        return powerExpo(a, MOD - 2);
    }   //for Prime MOD

    static void updateFenwick(int idx, long delta) {
        idx++;
        while (idx <= n) {
            bit[idx] += delta;
            idx += idx & -idx;
        }
    }

    static long queryFenwick(int idx) {
        idx++;
        long sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        FastReaderM2 sc = new FastReaderM2();
        int test = sc.nextInt();
        while (test-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            List<Long> sa = new ArrayList<>();
            List<Long> sb = new ArrayList<>();
            sa.add(a);
            while (a > 0) {
                a /= x;
                sa.add(a);
            }
            sb.add(b);
            while (b > 0) {
                b /= x;
                sb.add(b);
            }

            long ans = Integer.MAX_VALUE;
            for (int i = 0; i < sa.size(); i++) {
                for (int j = 0; j < sb.size(); j++) {
                    long possibleAns = i + j + Math.abs(sa.get(i) - sb.get(j));
                    ans = Math.min(ans, possibleAns);
                }
            }
            System.out.println(ans);
        }
    }
}
