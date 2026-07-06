import java.util.*;

public class Biggrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int k = sc.nextInt();
            int c = 0;
            boolean hg = false;
            for (int i = 0; i < k; i++) {
                int ch = sc.nextInt();
                if (ch >= 3) {
                    hg = true;
                }
                if (ch >= 2) {
                    c++;
                }
            }
            if (hg || c >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
