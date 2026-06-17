import java.util.*;

public class MonoPati {
    static boolean check(TreeSet<Integer>[] st, int n) {
        if (st[0].contains(0)) return false;
        if (st[1].contains(n - 1)) return false;

        int firstBlockedTop = st[0].first();
        int lastBlockedBottom = st[1].last();

        return firstBlockedTop - 1 > lastBlockedBottom;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();

            int[][] grid = new int[2][n];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            ArrayList<int[]>[] pos = new ArrayList[2 * n + 1];

            for (int i = 0; i <= 2 * n; i++) {
                pos[i] = new ArrayList<>();
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    pos[grid[i][j]].add(new int[]{i, j});
                }
            }

            TreeSet<Integer>[] st = new TreeSet[2];
            st[0] = new TreeSet<>();
            st[1] = new TreeSet<>();

            st[0].add(n);
            st[1].add(-1);

            for (int i = 0; i < n; i++) {
                st[0].add(i);
                st[1].add(i);
            }

            long ans = 0;
            int r = 0;

            for (int l = 1; l <= 2 * n; l++) {

                while (r + 1 <= 2 * n && !check(st, n)) {
                    r++;

                    for (int[] cell : pos[r]) {
                        st[cell[0]].remove(cell[1]);
                    }
                }

                if (!check(st, n)) {
                    break;
                }

                ans += (2L * n - r + 1);

                for (int[] cell : pos[l]) {
                    st[cell[0]].add(cell[1]);
                }
            }

            System.out.println(ans);
        }
    }
}
