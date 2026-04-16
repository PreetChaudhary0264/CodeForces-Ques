import java.util.Arrays;
import java.util.Scanner;

public class BingoCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int max = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                    max = Math.max(max,arr[i][j]);
                }
            }
            int[] freq = new int[max+1];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    freq[arr[i][j]]++;
                }
            }
            Arrays.sort(freq);
            int sum = 0;
            for(int i = freq.length - 2; i >= 0; i--){
                if(freq[i] == 0 || sum >= n)break;
                sum += freq[i];
            }
            if(sum >= n) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
