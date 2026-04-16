import java.util.Scanner;
public class Equalizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextLong();
        }

        if (sum % 2 != 0 || (n * k) % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
