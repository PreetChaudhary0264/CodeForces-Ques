import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long k = y / x;

            if (k == 2) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
