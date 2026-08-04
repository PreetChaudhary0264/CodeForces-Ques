import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int ans = 0;
            for(int k = 1; k * k <= n; k++){
                if(n % k == 0){
                    ans += solve(k,n,arr);
                    if(k != (n / k)){
                        ans += solve(n / k,n,arr);
                    }
                }
            }
            System.out.println(ans);
        }
    }
    private  static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    private static int solve(int k,int n,int[] arr){
        if(k == n)return 1;

        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < k; j++){
            int gcd_ = 0;
            for(int i = j+k; i < n; i+= k){
                int diff = Math.abs(arr[i] - arr[j]);
                gcd_ = gcd(gcd_,diff);
            }
            list.add(gcd_);
        }
        int gcd_ = 0;
        for(int val : list){
            gcd_ = gcd(gcd_,val);
        }
        if (gcd_ != 1) return 1;
        return 0;
    }
}
