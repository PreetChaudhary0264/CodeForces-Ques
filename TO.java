import java.util.Arrays;
import java.util.Scanner;

public class TO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j < m; j++){
            dp[n][j] = s2.length() - j;
        }
        for(int i = 0; i < n; i++){
            dp[i][m] = s1.length() - i;
        }
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                int cost = Integer.MAX_VALUE;

                if(s1.charAt(i) == s2.charAt(j)){
                    cost = dp[i+1][j+1];
                }else{
                    cost = Math.min(cost,1 + dp[i+1][j+1]);
                    cost = Math.min(cost, 1 + dp[i+1][j]);
                    cost = Math.min(cost, 1 + dp[i][j+1]);
                }
                dp[i][j] = cost;
            }
        }
        System.out.println(dp[0][0]);
//        System.out.println(solve(0,0,s1,s2));
    }
//    private static int solve(int i,int j,String s,String t){
//        if(i == s.length())return t.length() - j;  //agar s kjtm ho gyi to hme char add krne pdenge s me
//        if(j == t.length())return s.length() - i; //agar t khtm ho gyi to hme char delte krne pdenge s se
//
//        int cost = Integer.MAX_VALUE;
//        if(s.charAt(i) == t.charAt(j)){
//            cost = solve(i+1,j+1,s,t);
//        }else{
//            cost = Math.min(cost, 1 + solve(i+1,j+1,s,t));
//
//            cost = Math.min(cost, 1 + solve(i+1,j,s,t));
//
//            cost = Math.min(cost, 1 + solve(i,j+1,s,t));
//        }
//        return cost;
//    }
}
