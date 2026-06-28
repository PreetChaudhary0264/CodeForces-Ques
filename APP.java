import java.util.Arrays;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            long sa = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sa += a[i];
            }
            long sb = 0;
            boolean v = true;
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                sb += b[i];
                if (a[i] < b[i]) {
                    v = false;
                }
            }
            int[] aSorted = a.clone();
            int[] bSorted = b.clone();
            Arrays.sort(aSorted);
            Arrays.sort(bSorted);
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (aSorted[i] < bSorted[i]) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                System.out.println(-1);
            } else {
                long tc = sa - sb;
                if (v) {
                    System.out.println(tc);
                } else {
                    System.out.println(tc + c);
                }
            }
        }
    }
}
