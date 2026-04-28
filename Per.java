import java.util.*;
import java.io.*;

public class Per {

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = Long.parseLong(st.nextToken());
            }

            long count = 0;
            for (int i = 0; i + 1 < n; i++) {
                long diff = Math.abs(p[i] - p[i + 1]);
                long g = gcd(p[i], p[i + 1]);
                if (diff == g) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
