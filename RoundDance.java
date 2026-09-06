import java.util.*;

public class RoundDance {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            int p = 0;
            Map<Integer, Integer> mpp = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int val = sc.nextInt();
                arr[i] = val;
                mpp.put(i, val);
                if (mpp.containsKey(val) && mpp.get(val) == i) {
                    p++;
                }
                union(i, val);
            }
            Set<Integer> components = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                components.add(find(i));
            }
            int max = components.size();
            int min = p > 0 ? max - p + 1 : max;
            System.out.println(min + " " + max);
        }
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}
