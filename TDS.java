import java.util.Scanner;

public class TDS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            String a = sc.next();
            String b = sc.next();
            int n = a.length();
            int m  =b.length();
            int[] prea = new int[n];
            int[] preb = new int[m];
            int sum = a.charAt(0) - '0';
            prea[0] = sum;
            for(int i = 1; i < n; i++){
                int num = a.charAt(i) - '0';
                sum = (sum + num) % 10;
                prea[i] = sum;
            }
            sum = b.charAt(0) - '0';
            preb[0] = sum;
            for(int i = 1; i < m; i++){
                int num = b.charAt(i) - '0';
                sum = (sum + num) % 10;
                preb[i] = sum;
            }
            if(prea[n-1] != preb[m-1]){
                System.out.println(-1);
                continue;
            }
            System.out.println(1 + solve(prea,preb));
        }
    }
    private static int solve(int[] a,int[] b){
        int n = a.length-1;int n2 = b.length-1;
        int[][] dp = new int[n+1][n2+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = n2-1; j >= 0; j--){
                if(a[i] == b[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
