import java.util.Scanner;

public class SimonsAndCakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                long n = sc.nextLong();
                sb.append(findRadical(n)).append("\n");
            }
            System.out.print(sb.toString());
        }
        sc.close();
    }
    public static long findRadical(long n) {
        long res = 1;
        long temp = n;

        for (long i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                res *= i; // Include the prime factor once
                // Remove all occurrences of this prime factor
                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }

        // If temp is still > 1, the remaining temp is a prime factor
        if (temp > 1) {
            res *= temp;
        }
        return res;
    }
}
