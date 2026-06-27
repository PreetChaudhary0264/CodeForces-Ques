import java.util.Scanner;

public class PopCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long ans = 0;
            long val = 1;
            while (val <= n) {
                long cnt = Math.min(k, n / val);
                ans += cnt;
                n -= cnt * val;
                val <<= 1;
            }
            System.out.println(ans);
        }
    }
}
