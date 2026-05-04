import java.util.*;

public class WhereIsMyWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long h = sc.nextLong();
            long[] v = new long[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLong();
            }

            // cnt[i] store karega ki i-th column par drain rakhne se kitna total water niklega
            long[] cnt = new long[n];
            for (int i = 0; i < n; i++) {
                long currentTotal = h - v[i];

                // Right side check karo
                long maxH = v[i];
                for (int j = i + 1; j < n; j++) {
                    maxH = Math.max(maxH, v[j]);
                    currentTotal += (h - maxH);
                }

                // Left side check karo
                maxH = v[i];
                for (int j = i - 1; j >= 0; j--) {
                    maxH = Math.max(maxH, v[j]);
                    currentTotal += (h - maxH);
                }
                cnt[i] = currentTotal;
            }

            long best = 0;
            // Har pair (i, j) ke liye best combination dhoondo
            for (int i = 0; i < n; i++) {
                long maxValBetween = v[i];
                int arg = i;

                for (int j = i; j < n; j++) {
                    // i aur j ke beech ki sabse unchi wall track karo
                    if (v[j] > maxValBetween) {
                        maxValBetween = v[j];
                        arg = j;
                    }

                    // Inclusion-Exclusion: Area(i) + Area(j) - Area(intersection)
                    // Intersection area wahi hota hai jo sabse unchi wall (arg) se cover ho
                    long currentCombination = cnt[i] + cnt[j] - cnt[arg];
                    best = Math.max(best, currentCombination);
                }
            }

            System.out.println(best);
        }
        sc.close();
    }
}
