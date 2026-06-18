import java.util.Scanner;

public class DT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)arr[i] = sc.nextInt();
            long ans = 0;
            int val = Integer.MAX_VALUE;
            for(int i  =0; i < n; i++){
                val = Math.min(val,arr[i]);
                ans +=val;
            }
            System.out.println(ans);
        }
    }
}
