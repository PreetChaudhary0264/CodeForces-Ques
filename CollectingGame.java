import java.util.*;

public class CollectingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long n = scanner.nextLong();
            List<Pair> v = new ArrayList<>();
            for (int i = 0; i < n; i++) { // O(n)
                long a = scanner.nextLong();
                v.add(new Pair(a, i));
            }

            long[] pre = new long[(int) n];
            Collections.sort(v, Comparator.comparingLong(pair -> pair.first));

            pre[0] = v.get(0).first;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + v.get(i).first;
            }

            long[] ans = new long[(int) n];
            for (int i = 0; i < n; i++) {
                int j = i;
                int found = i;
                while (j < n) {
                    Pair temp = new Pair(pre[j] + 1, Long.MIN_VALUE);
                    int l = 0, r = v.size();
                    while (l < r) {
                        int mid = (l + r) >>> 1;
                        if (v.get(mid).first < temp.first)
                            l = mid + 1;
                        else
                            r = mid;
                    }
                    int idx = l;
                    idx--;

                    if (idx == j) {
                        break;
                    }
                    found += idx - j;
                    j = idx;
                }
                ans[(int) v.get(i).second] = found;
            }
            for (int i = 0; i < n; i++) { // O(n)
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
    static class Pair {
        long first, second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
