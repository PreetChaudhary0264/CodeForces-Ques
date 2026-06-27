import java.util.Scanner;

public class Knapsack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        long[][] arr = new long[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }
        long[][] dp = new long[n][w+1];
        for(int j = (int )arr[0][0]; j <= w; j++){
            dp[0][j] = arr[0][1];
        }
        for(int i = 1; i < n; i++){
            long weight = arr[i][0];
            long value = arr[i][1];
            for(int j = 0; j <= w; j++){
                dp[i][j] = dp[i-1][j];
                if(j-weight >= 0)dp[i][j] = Math.max(dp[i][j], dp[i-1][(int)(j-weight)] + value);
            }
        }
        System.out.println(dp[n-1][w]);
    }
}
