import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YetAnotherProblemAboutPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> processed = new ArrayList<>();
            long ans = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] >= i+1)continue;

                ans += (long) solve(processed,arr[i]);
                processed.add(i+1);
            }
            System.out.println(ans);
        }
    }
    private static int solve(List<Integer> arr, int target){
        int l = 0;
        int r = arr.size()-1;
        int ans = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr.get(mid) < target){
                ans = mid + 1;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;
    }
}
