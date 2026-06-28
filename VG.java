import java.util.*;
public class VG {
    static Map<Integer, List<Integer>> tree;
    static int[] max1, max2, depth;
    static long ans;
    static void dfs(int node, int d) {
        depth[node] = d;
        max1[node] = d;
        max2[node] = d;
        for (int child : tree.getOrDefault(node, new ArrayList<>())) {
            dfs(child, d + 1);

            if (max1[child] > max1[node]) {
                max2[node] = max1[node];
                max1[node] = max1[child];
            } else if (max1[child] > max2[node]) {
                max2[node] = max1[child];
            }
        }
        ans += max2[node] - depth[node] + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            tree = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                tree.put(i, new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                int parent = sc.nextInt();
                tree.get(parent).add(i);
            }
            max1 = new int[n + 1];
            max2 = new int[n + 1];
            depth = new int[n + 1];
            ans = 0;
            dfs(1, 0);
            System.out.println(ans);
        }
    }
}
