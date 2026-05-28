import java.util.*;

public class RSM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();

            long ans = 0;
            boolean[] isRemoved = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    if (s.charAt(j - 1) == '1')
                        break;
                    if (isRemoved[j])
                        continue;
                    else {
                        isRemoved[j] = true;
                        ans += i;
                    }
                }
            }

            System.out.println(ans);
        }

        scanner.close();
    }
}

