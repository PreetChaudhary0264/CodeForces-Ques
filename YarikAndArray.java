import java.util.*;

public class YarikAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long[] v = new long[(int) n];

            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLong();
            }

            long ans = Long.MIN_VALUE;
            int i = 0, j = 0;
            long sum = 0;

            while (j < n) {
                if (sum < 0) {
                    sum = 0;
                    i = j;
                }

                if (i < j) {
                    if ((v[j] ^ v[j - 1]) % 2 != 0) {
                        sum += v[j];
                    } else {
                        sum = v[j];
                        i = j;
                    }
                } else {
                    sum = v[j];
                }

                ans = Math.max(ans, sum);
                j++;
            }

            System.out.println(ans);
        }
    }
}
