import java.util.Scanner;

public class Grid1 {
    static long MOD = (long) 1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] grid = new char[h][w];
        for(int i = 0; i < h; i++){
            String s = sc.next();
            for(int j = 0; j < w; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        long[][] dp = new long[h+1][w+1];
        dp[h-1][w-1] = 1;

        for(int i = h-1; i >= 0; i--){
            for(int j = w-1; j >= 0; j--){
//                if(grid[i][j] == '#')continue;
                if(i == h-1 && j == w-1)continue;
                long ways = 0;
                if(j+1 < w && grid[i][j+1] != '#')ways = (ways + dp[i][j+1]) % MOD;
                if(i+1 < h && grid[i+1][j] != '#')ways = (ways + dp[i+1][j]) % MOD;

                dp[i][j] = ways;
            }
        }
        System.out.println(dp[0][0]);
    }
}
