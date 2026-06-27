import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] p = new double[n];
        for(int i = 0; i < n; i++)p[i] = sc.nextDouble();
        int tailsPicked = n/2;
        double[][] dp = new double[n+1][tailsPicked+2];
        for(int i = 0; i <= tailsPicked; i++){  //base case
            dp[n][i] = 1;
        }
        dp[n][tailsPicked+1] = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = tailsPicked; j >= 0; j--){
                dp[i][j] += (p[i] * dp[i+1][j]);
                dp[i][j] += ((1 - p[i]) * dp[i+1][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
