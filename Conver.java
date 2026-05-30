import java.util.Scanner;
import java.util.Arrays;

public class Conver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int target = a[n / 2];

            int lc = 0;
            int rc = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < target) {
                    lc++;
                } else if (a[i] > target) {
                    rc++;
                }
            }
            System.out.println(Math.max(lc, rc));
        }
    }
}
