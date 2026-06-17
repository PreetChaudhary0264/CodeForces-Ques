import java.util.Scanner;

public class BlockSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)arr[i] = sc.nextInt();
            int[] dp = new int[n+1];
            dp[n] = 0;
            for(int i = n-1; i >= 0; i--){
                int j = i + arr[i] + 1;
                if(j <= n){
                    dp[i] = Math.min(dp[i+1] + 1,dp[j]);
                }else{
                    dp[i] = dp[i+1] + 1;
                }
            }
            System.out.println(dp[0]);
        }
    }
}