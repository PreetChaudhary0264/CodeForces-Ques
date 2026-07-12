import java.util.Scanner;

public class MortalKombatTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)arr[i] = sc.nextInt();
            int[][] dp = new int[n+1][2];
            dp[n-1][0] = 0;
            dp[n-1][1] = arr[n-1];
            for(int i = n-2; i >= 0; i--){
                for(int turn = 0; turn < 2; turn++){
                    int ans = 0;
                    if(turn == 0){
                        ans += Math.min(dp[i+1][1], dp[i+2][1]);
                    }else{
                        ans += Math.min(dp[i+1][0] + arr[i], dp[i+2][0] + arr[i] + arr[i+1]);
                    }
                    dp[i][turn] = ans;
                }
            }
            System.out.println(dp[0][1]);
        }
    }
}
