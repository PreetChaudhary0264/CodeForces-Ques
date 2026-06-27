import java.util.Arrays;
import java.util.Scanner;

public class Knapsack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        long[][] arr = new long[n][2];
        long sumVal = 0;
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
            sumVal += arr[i][1];
        }
        long INF = (long)1e18;
        long[] dp = new long[(int)sumVal + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int i = 0; i < n; i++){
            int val = (int)arr[i][1];
            long wt = arr[i][0];

            for(int v = (int) sumVal; v >= val; v--){
                dp[v] = Math.min(
                        dp[v],
                        dp[v - val] + wt
                );
            }
        }
        for(int v = (int)sumVal; v >= 0; v--){
            if(dp[v] <= w){
                System.out.println(v);
                break;
            }
        }
    }
}
