import java.io.*;
import java.util.*;
public class GoodsOnTheShelf {

    static class FastReaderM9 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM9() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    static int cm = 0;
    static int[] visited = new int[200005];
    static class Segment {
        int num;
        int left;
        int right;

        Segment(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
    static boolean check(int[] nums, int n) {
        cm++;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != prev) {
                if (visited[nums[i]] == cm) {
                    return false;
                }
                visited[nums[i]] = cm;
                prev = nums[i];
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {

        FastReaderM9 fr = new FastReaderM9();
        StringBuilder ans = new StringBuilder();
        int test = fr.nextInt();
        while (test-- > 0) {
            int n = fr.nextInt();
            int[] original = new int[n];
            for (int i = 0; i < n; i++) {
                original[i] = fr.nextInt();
            }
            HashMap<Integer, Integer> compress = new HashMap<>();
            int distinct = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                if (!compress.containsKey(original[i])) {
                    compress.put(original[i], ++distinct);
                }
                nums[i] = compress.get(original[i]);
            }
            List<Segment> segments = new ArrayList<>();
            int l = 0;
            for (int i = 1; i <= n; i++) {
                if (i == n || nums[i] != nums[i - 1]) {
                    segments.add(new Segment(nums[l], l, i - 1));
                    l = i;
                }
            }
            int blockCount = segments.size();
            if (blockCount > distinct + 4) {
                ans.append("NO\n");
                continue;
            }
            int[] cnt = new int[distinct + 1];
            for (Segment seg : segments) {
                cnt[seg.num]++;
            }
            List<Integer> problematic = new ArrayList<>();
            for (int i = 0; i < blockCount; i++) {
                if (cnt[segments.get(i).num] > 1) {
                    problematic.add(i);
                }
            }
            if (problematic.isEmpty()) {
                ans.append("YES\n");
                continue;
            }
            Set<Integer> firstCandidates = new HashSet<>();
            Set<Integer> secondCandidates = new HashSet<>();
            for (int idx : problematic) {
                Segment cur = segments.get(idx);
                firstCandidates.add(cur.left);
                firstCandidates.add(cur.right);
                for (int j = idx - 1; j <= idx + 1; j++) {
                    if (j >= 0 && j < blockCount) {
                        secondCandidates.add(segments.get(j).left);
                        secondCandidates.add(segments.get(j).right);
                    }
                }
            }
            boolean found = false;
            for (int x : firstCandidates) {
                for (int y : secondCandidates) {
                    if (x == y) {
                        continue;
                    }
                    int temp = nums[x];
                    nums[x] = nums[y];
                    nums[y] = temp;
                    if (check(nums, n)) {
                        found = true;
                        break;
                    }
                    temp = nums[x];
                    nums[x] = nums[y];
                    nums[y] = temp;
                }
                if (found) {
                    break;
                }
            }
            ans.append(found ? "YES\n" : "NO\n");
        }
        System.out.print(ans);
    }
}
