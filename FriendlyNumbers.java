import java.util.Scanner;

public class FriendlyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long x = sc.nextLong();
                int count = 0;
                for (long y = x; y <= x + 100; y++) {
                    if (y - sumDigits(y) == x) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
    public static long sumDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
