import java.util.Scanner;

public class DigitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            int[] suffix = new int[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                char c = s.charAt(i);

                suffix[i] = suffix[i + 1];

                if (c == '1' || c == '3') {
                    suffix[i]++;
                }
            }

            int twos = 0;
            int best = 0;

            for (int i = 0; i <= n; i++) {
                best = Math.max(best, twos + suffix[i]);

                if (i < n && s.charAt(i) == '2') {
                    twos++;
                }
            }

            System.out.println(n - best);
        }
    }
}
