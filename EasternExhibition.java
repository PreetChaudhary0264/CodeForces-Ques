import java.util.Arrays;
import java.util.Scanner;

public class EasternExhibition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] xaxis = new int[n];
            int[] yaxis = new int[n];
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                xaxis[i] = x;
                yaxis[i] = y;
            }
            if(n % 2 != 0){
                System.out.println(1);
                continue;
            }
            Arrays.sort(xaxis);
            Arrays.sort(yaxis);
            int mid = n / 2;
            long ans = (long)(xaxis[mid] - xaxis[mid-1] + 1) * (yaxis[mid] - yaxis[mid-1] + 1);
            System.out.println(ans);
        }
    }
}
