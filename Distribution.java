import java.util.Scanner;

public class Distribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int MOD = 676767677;
        while(test-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextLong();
            }
            long ans = 0;
            boolean oneMila = false;
            long greater = -1;
            for(int i = 0; i < n; i++){
                if(arr[i] > 1){
                    ans = (ans + arr[i]) % MOD;
                }
            }
            for(int i = n-1; i >= 0; i--){
                if(arr[i] == 1 && greater == -1){
                    oneMila = true;
                    break;
                }
                greater = Math.max(greater, arr[i]);
            }
            if(oneMila){
                System.out.println(ans+1);
            }else{
                System.out.println(ans);
            }
        }
    }
}
