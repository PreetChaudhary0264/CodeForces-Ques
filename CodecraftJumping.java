import java.util.Scanner;

public class CodecraftJumping {

    // Function to calculate Greatest Common Divisor
    public static long gcd(long x, long y) {
        while (y != 0) {
            x %= y;
            // Swap x and y
            long temp = x;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            // 1. Check if he can traverse all rows
            boolean canTraverseRows = (gcd(a, n) == 1);

            // 2. Check if he can traverse all columns
            boolean canTraverseCols = (gcd(b, m) == 1);

            // 3. Check the interaction between row and column cycles
            // Based on alternating moves, the GCD of dimensions must be <= 2
            long gNM = gcd(n, m);
            boolean cycleConstraint = false;

            if (gNM == 1) {
                cycleConstraint = true;
            } else if (gNM == 2) {
                // If gcd is 2, he can only finish if a and b allow 
                // crossing the parity boundary (essentially a, b must be odd)
                if (a % 2 != 0 && b % 2 != 0) {
                    cycleConstraint = true;
                }
            }

            if (canTraverseRows && canTraverseCols && cycleConstraint) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}