import java.util.*;
public class StormingA {
    static int getSize(int x) {
        int cnt = 0;
        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                cnt++;
                x /= i;
            }
        }
        if (x > 1) cnt++;
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    set.add(getSize(i));
                    if (i != n / i) {
                        set.add(getSize(n / i));
                    }
                }
            }
            set.add(getSize(n));
            int distPrimes = 0;
            int x = n;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    distPrimes++;
                    while (x % i == 0) {
                        x /= i;
                    }
                }
            }
            if (x > 1) distPrimes++;
            System.out.println(set.size() - 1 + distPrimes);
        }
    }
}
