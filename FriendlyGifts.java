import java.util.*;

public class FriendlyGifts {
    static class Subarray {
        int l, r, min;
        public Subarray(int l, int r, int min) {
            this.l = l;
            this.r = r;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            List<Subarray>[] lists = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int min = a[i];
                int max = a[i];
                for (int j = i; j < n; j++) {
                    if (seen[a[j]]) {
                        for (int k = i; k < j; k++) seen[a[k]] = false;
                        break;
                    }
                    seen[a[j]] = true;
                    min = Math.min(min, a[j]);
                    max = Math.max(max, a[j]);
                    int len = j - i + 1;
                    if (max - min == len - 1) {
                        lists[len].add(new Subarray(i, j, min));
                    }
                    if (j == n - 1) {
                        for (int k = i; k <= j; k++) seen[a[k]] = false;
                    }
                }
            }
            int ans = 0;
            for (int len = n / 2; len >= 1; len--) {
                List<Subarray> currentLengthSegments = lists[len];
                boolean found = false;
                for (int i = 0; i < currentLengthSegments.size(); i++) {
                    Subarray seg1 = currentLengthSegments.get(i);
                    for (int j = i + 1; j < currentLengthSegments.size(); j++) {
                        Subarray seg2 = currentLengthSegments.get(j);
                        if (Math.abs(seg1.min - seg2.min) == len) {
                            if (seg1.r < seg2.l || seg2.r < seg1.l) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) break;
                }
                if (found) {
                    ans = len;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
