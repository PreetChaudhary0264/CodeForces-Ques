import java.util.Scanner;

public class HSL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int h = sc.nextInt();
            int S = sc.nextInt();
            int l = sc.nextInt();
            int[][][] dp = new int[1001][101][101];
            //base case count == h
            for(int i = 1; i <= S; i++){
                for(int j = 0; j <= l; j++){
                    dp[h][i][j] = 1;
                }
            }
            for(int count = h-1; count >= 0; count--){
                for(int s = 1; s <= S; s++){
                    for(int used = l; used >= 0; used--){

                        int ways = dp[count][s-1][0];

                        if(used < l){
                            ways += dp[count+1][s][used+1];
                        }

                        dp[count][s][used] = ways;
                    }
                }
            }
            System.out.println(dp[0][S][0]);
        }
    }
}
