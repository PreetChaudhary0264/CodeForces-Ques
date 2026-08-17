import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArrRep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            // Lists to hold differences grouped by parity
            ArrayList<Long> evenDiffs = new ArrayList<>();
            ArrayList<Long> oddDiffs = new ArrayList<>();

            // Keep track of the original parity pattern of the differences
            boolean[] isEvenPattern = new boolean[n - 1];

            for (int i = 0; i < n - 1; i++) {
                long diff = a[i + 1] - a[i];
                if (diff % 2 == 0) {
                    evenDiffs.add(diff);
                    isEvenPattern[i] = true;
                } else {
                    oddDiffs.add(diff);
                    isEvenPattern[i] = false;
                }
            }

            // Sort both lists to pick the smallest available differences first
            Collections.sort(evenDiffs);
            Collections.sort(oddDiffs);

            long[] res = new long[n];
            res[0] = a[0]; // The first element never changes

            int evenIdx = 0;
            int oddIdx = 0;

            // Reconstruct the array
            for (int i = 0; i < n - 1; i++) {
                if (isEvenPattern[i]) {
                    res[i + 1] = res[i] + evenDiffs.get(evenIdx++);
                } else {
                    res[i + 1] = res[i] + oddDiffs.get(oddIdx++);
                }
            }

            // Build the output string for the current test case
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(res[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }

        scanner.close();
    }
}
