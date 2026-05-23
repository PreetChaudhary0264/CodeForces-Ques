import java.util.Scanner;

public class SlimesOnALine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();

            int mnv = Integer.MAX_VALUE;
            int mxv = Integer.MIN_VALUE;

            // Find the minimum and maximum positions in the array
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a < mnv) mnv = a;
                if (a > mxv) mxv = a;
            }
            int ans = (mxv - mnv + 1) / 2;

            System.out.println(ans);
        }

        sc.close();
    }
}
