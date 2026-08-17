import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RiskyTower {
    static class FastReaderM233 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM233() {
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
    public static void main(String[] args) throws IOException {
        FastReaderM233 sc = new FastReaderM233();

        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLong();
            }
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int ans = m;
//            PriorityQueue<Integer> topM = new PriorityQueue<>();
            int[] topM = new int[m];
            int topSize = 0;
            int[] nextTop = new int[m];

            for (int i = n - 1; i >= 0; i--) {
//                for (int j = 0; j < m; j++) {
//                    if (topM.size() < m) {
//                        topM.add(a[i][j]);
//                    } else if (a[i][j] > topM.peek()) {
//                        topM.poll();
//                        topM.add(a[i][j]);
//                    }
//                }
                Arrays.sort(a[i]);
                int p1 = 0;
                int p2 = m - 1;
                int count = 0;
                while (count < m && (p1 < topSize || p2 >= 0)) {
                    if (p1 < topSize && p2 >= 0) {
                        if (topM[p1] >= a[i][p2]) {
                            nextTop[count++] = topM[p1++];
                        } else {
                            nextTop[count++] = a[i][p2--];
                        }
                    } else if (p1 < topSize) {
                        nextTop[count++] = topM[p1++];
                    } else {
                        nextTop[count++] = a[i][p2--];
                    }
                }
                int[] temp = topM;
                topM = nextTop;
                nextTop = temp;
                topSize = count;
//                Integer[] currentTop = topM.toArray(new Integer[0]);
//                Arrays.sort(currentTop, Collections.reverseOrder());
                long currentSum = 0;
                for (int j = 0; j < topSize; j++) {
                    currentSum += topM[j];
                    if (currentSum >= v[i]) {
                        ans = Math.min(ans, j + 1);
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
