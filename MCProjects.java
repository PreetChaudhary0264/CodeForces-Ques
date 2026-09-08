import java.util.Scanner;

public class MCProjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long test = sc.nextLong();
        while (test-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long k = sc.nextLong();
            long ans = 0;

            while (k > 0) {
                long q = y / x;
                long r = y % x;
                if (q == 0) {
                    ans += k * y + (k * (k - 1)) / 2;
                    break;
                }
                if (q == 1) {
                    ans += (y - x) * k;
                    break;
                }
                long dec = q - 1;
                long steps = (r / dec) + 1;

                if (steps > k) steps = k;
                long start = r;
                long end = r - (steps - 1) * dec;
                ans += steps * (start + end) / 2;
                x += steps;
                y += steps;
                k -= steps;
            }
            System.out.println(ans);
        }
    }
}
