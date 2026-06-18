import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i  =0; i  < n; i++)arr[i] = sc.nextInt();
        int[] dp = new int[n + k];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int jump = 1; jump <= k && i + jump < n; jump++){
                dp[i+jump] = Math.min(dp[i+jump], dp[i] + Math.abs(arr[i] - arr[i + jump]));
            }
        }
        System.out.println(dp[n-1]);
    }
}