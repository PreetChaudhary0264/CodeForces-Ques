import java.util.Scanner;

public class Kstones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)arr[i] = sc.nextInt();
        boolean[] dp = new boolean[k+1];
        for(int i = 1; i <= k; i++){
            for(int j = 0; j < n; j++){
                int x = arr[j];
                if(i >= x && i - x >= 0 && !dp[i - x]){
                    dp[i] = true;
                    break;
                }
                else dp[i] = false;
            }
        }
        if(dp[k]) System.out.println("First");
        else System.out.println("Second");
    }
}
