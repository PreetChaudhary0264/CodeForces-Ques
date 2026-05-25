import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long[] prefix = new long[n];
            prefix[0] = Math.abs((long) a[0]);

            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + Math.abs((long) a[i]);
            }

            long[] suffix = new long[n];
            suffix[n - 1] = a[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + a[i];
            }

            long totalSum = 0;

            for (int i = 0; i < n; i++) {
                totalSum += a[i];
            }

            long ans = totalSum;
            int bestIdx = -1;

            for (int i = 0; i < n; i++) {

                if (a[i] > 0) {

                    long left = (i > 0 ? prefix[i - 1] : 0);
                    long right = (i + 1 < n ? suffix[i + 1] : 0);

                    long sum = left + right - a[i];

                    if (sum > ans) {
                        bestIdx = i;
                        ans = sum;
                    }
                }
            }

            if (bestIdx == -1) {
                System.out.println(0);
                System.out.println();
                continue;
            }

            List<Integer> list = new ArrayList<>();

            int change = 0;

            for (int i = bestIdx - 1; i >= 0; i--) {

                long cur = a[i];

                if (change == 1) {
                    cur = -cur;
                }

                if (cur > 0) {
                    list.add(i + 1);
                    change ^= 1;
                }
            }

            list.add(bestIdx + 1);

            System.out.println(list.size());

            for (int x : list) {
                System.out.print((x) + " ");
            }

            System.out.println();
        }
    }
}