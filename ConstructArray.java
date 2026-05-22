import java.util.*;

public class ConstructArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.print((2 * i - 1) + " ");
            }

            System.out.println();
        }
    }
}
