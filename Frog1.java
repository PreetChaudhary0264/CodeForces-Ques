import java.util.Arrays;
import java.util.Scanner;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i  =0; i  < n; i++)arr[i] = sc.nextInt();
        int[] dp = new int[n + 3];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            int oneJump = (i+1 < n) ? Math.abs(arr[i] - arr[i+1]): Integer.MAX_VALUE;
            int twoJump = (i+2< n) ? Math.abs(arr[i] - arr[i+2]): Integer.MAX_VALUE;
            dp[i+1] = Math.min(dp[i+1],dp[i] + oneJump);
            dp[i+2] = Math.min(dp[i+2],dp[i] + twoJump);
        }
        System.out.println(dp[n-1]);
    }
}
