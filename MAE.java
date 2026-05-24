import java.util.*;

public class MAE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }
            long ans = 0;
            for (int i = 1; i <= 60; i++) {
                Set<Long> distinctVals = new HashSet<>();
                long k = 1L << i;
                for (int ind = 0; ind < n; ind++) {
                    distinctVals.add(arr[ind] % k);
                }
                if (distinctVals.size() == 2) {
                    ans = k;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}

