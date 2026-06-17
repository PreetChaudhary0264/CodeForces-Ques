import java.util.*;

public class PizzaDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {

            int n = sc.nextInt();
            int ax = sc.nextInt();
            int ay = sc.nextInt();
            int bx = sc.nextInt();
            int by = sc.nextInt();

            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }

            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
            }

            int[] sorted = x.clone();
            Arrays.sort(sorted);

            List<Integer> dx = new ArrayList<>();
            for (int val : sorted) {
                if (dx.isEmpty() || dx.get(dx.size() - 1) != val) {
                    dx.add(val);
                }
            }

            int m = dx.size();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                map.put(dx.get(i), i);
            }

            long[][] arr = new long[m][2];

            for (int i = 0; i < m; i++) {
                arr[i][0] = Long.MAX_VALUE;
                arr[i][1] = Long.MIN_VALUE;
            }

            for (int i = 0; i < n; i++) {
                int idx = map.get(x[i]);

                arr[idx][0] = Math.min(arr[idx][0], y[i]);
                arr[idx][1] = Math.max(arr[idx][1], y[i]);
            }

            long[][] dp = new long[m][2];

            dp[0][0] =
                    Math.abs(dx.get(0) - ax)
                            + Math.abs(arr[0][1] - ay)
                            + (arr[0][1] - arr[0][0]);

            dp[0][1] =
                    Math.abs(dx.get(0) - ax)
                            + Math.abs(arr[0][0] - ay)
                            + (arr[0][1] - arr[0][0]);

            for (int i = 1; i < m; i++) {

                long xDist = dx.get(i) - dx.get(i - 1);
                long len = arr[i][1] - arr[i][0];

                dp[i][0] = Math.min(
                        dp[i - 1][0]
                                + xDist
                                + Math.abs(arr[i - 1][0] - arr[i][1])
                                + len,

                        dp[i - 1][1]
                                + xDist
                                + Math.abs(arr[i - 1][1] - arr[i][1])
                                + len
                );

                dp[i][1] = Math.min(
                        dp[i - 1][0]
                                + xDist
                                + Math.abs(arr[i - 1][0] - arr[i][0])
                                + len,

                        dp[i - 1][1]
                                + xDist
                                + Math.abs(arr[i - 1][1] - arr[i][0])
                                + len
                );
            }

            long ans1 =
                    dp[m - 1][0]
                            + (bx - dx.get(m - 1))
                            + Math.abs(arr[m - 1][0] - by);

            long ans2 =
                    dp[m - 1][1]
                            + (bx - dx.get(m - 1))
                            + Math.abs(arr[m - 1][1] - by);

            System.out.println(Math.min(ans1, ans2));
        }
    }
}
