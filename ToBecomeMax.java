import java.util.Scanner;

public class ToBecomeMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            long[] arr = new long[n];
            long ans = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                ans = Math.max(ans, arr[i]);
            }

            for (int i = 0; i < n - 1; i++) {
                long l = arr[i];
                long r = ans + k + 1;

                while (l <= r) {
                    long mid = l + (r - l) / 2;

                    if (check(arr, i, mid, k)) {
                        ans = Math.max(ans, mid);
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    private static boolean check(long[] arr, int idx, long target, long k) {
        long cost = target - arr[idx];
        if (cost > k) return false;
        k -= cost;

        for (int i = idx + 1; i < arr.length; i++) {
            target--;

            if (k == 0 && arr[i] < target) return false;

            if (arr[i] >= target) return true;

            long diff = target - arr[i];
            if (k < diff) return false;

            k -= diff;
        }

        return false;
    }
}
