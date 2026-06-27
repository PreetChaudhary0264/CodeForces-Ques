import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();int n2 = t.length();
        int[][] dp = new int[n+1][n2+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = n2-1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < n && j < n2){
            if(s.charAt(i) == t.charAt(j)){
                ans.append(s.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] >= dp[i][j+1]){
                i++;
            }
            else{
                j++;
            }
        }

        System.out.println(ans.toString());
    }
}
