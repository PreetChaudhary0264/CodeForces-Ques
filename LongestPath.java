import java.util.*;

//ye topo sort wali approach hai
//2nd apptroach me dfs + memoization => neeche likhi hai
public class LongestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            g[x].add(y);
            indegree[y]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] dp = new int[n + 1];

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : g[u]) {

                dp[v] = Math.max(dp[v], dp[u] + 1);

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int ans = 0;

        for (int x : dp) {
            ans = Math.max(ans, x);
        }

        System.out.println(ans);
    }
}


//
//import java.util.*;
//
//public class Main {
//
//    static ArrayList<Integer>[] g;
//    static int[] dp;
//
//    static int dfs(int u) {
//        if (dp[u] != -1) return dp[u];
//
//        int ans = 0;
//
//        for (int v : g[u]) {
//            ans = Math.max(ans, 1 + dfs(v));
//        }
//
//        return dp[u] = ans;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        g = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
//
//        for (int i = 0; i < m; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            g[x].add(y);
//        }
//
//        dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//
//        int ans = 0;
//
//        for (int i = 1; i <= n; i++) {
//            ans = Math.max(ans, dfs(i));
//        }
//
//        System.out.println(ans);
//    }
//}
