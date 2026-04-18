import java.util.Scanner;

public class AllInOneGun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int h = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            long roundsReq = h / sum;
            long rem = h % sum;
            long sec = (roundsReq * n) + (roundsReq * k);
            if(rem == 0)sec -= k;
            int add = 0;
            if(rem > 0){
                int low = 1;
                int high = n;
                while(low <= high){
                    int mid = low + (high - low) / 2;
                    if(isPossible(arr,mid,rem)){
                        add = mid;
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }
            System.out.println(sec + add);
        }
    }
    public static boolean isPossible(int[] arr,int mid,long rem){
        long min = Long.MAX_VALUE;
        long sum = 0;
        for(int i = 0; i < mid; i++){
            min = Math.min(min,arr[i]);
            sum += arr[i];
        }
        if(sum >= rem)return true;
        else{
            long max = Long.MIN_VALUE;
            for(int i = mid; i < arr.length; i++){
                max = Math.max(max,arr[i]);
            }
            sum -= min;
            sum += max;
            return sum >= rem;
        }
    }
}
