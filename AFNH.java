import java.util.Scanner;

public class AFNH {
    static final long MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long r = sc.nextLong();
            long c = sc.nextLong();
            long total = n * m;
            long eq = (n - r + 1) * (m - c + 1);
            long free = total - eq;
            System.out.println(pow(2, free));
        }
    }
    static long pow(long a, long b) {
        long ans = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) ans = (ans * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
}
