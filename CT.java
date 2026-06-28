import java.util.Scanner;

public class CT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            long ans = 0;
            for (int b = 1; b <= n; b++) {
                long tp = n / b;
                ans += (tp * tp);
            }

            System.out.println(ans);
        }
    }
}
