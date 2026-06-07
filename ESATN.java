import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ESATN {

    static class FastReaderM5 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM5() {
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

    private static boolean check(int[] arr, int n) {
        for (int i = 0; i + 2 < n; i++) {
            if (arr[i] % arr[i + 1] != arr[i + 2]) {
                return false;
            }
        }
        return true;
    }

    private static void solve(FastReaderM5 fr, StringBuilder ans) throws IOException {
        int n = fr.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }

        Arrays.sort(arr);

        int left = 0, right = n - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        if (check(arr, n)) {
            ans.append(arr[0]).append(" ").append(arr[1]).append("\n");
        } else {
            ans.append("-1\n");
        }
    }

    public static void main(String[] args) throws Exception {
        FastReaderM5 fr = new FastReaderM5();
        StringBuilder ans = new StringBuilder();

        int test = fr.nextInt();

        while (test-- > 0) {
            solve(fr, ans);
        }

        System.out.print(ans);
    }
}
