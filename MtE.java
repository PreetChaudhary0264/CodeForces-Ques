import java.util.Scanner;

public class MtE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            char c = scanner.next().charAt(0);
            String s = scanner.next();

            boolean check0 = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c) {
                    check0 = false;
                    break;
                }
            }

            if (check0) {
                System.out.println("0");
                continue;
            }

            int val1 = -1;
            for (long i = 2; i <= n; i++) {
                boolean isPoss = true;
                for (long j = i; j <= n; j += i) {
                    if (s.charAt((int) j - 1) != c) {
                        isPoss = false;
                        break;
                    }
                }

                if (isPoss) {
                    val1 = (int) i;
                    break;
                }
            }

            if (val1 != -1) {
                System.out.println("1");
                System.out.println(val1);
                continue;
            }

            System.out.println("2");
            System.out.println((n - 1) + " " + n);
        }
        scanner.close();
    }
}
