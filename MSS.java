import java.util.Scanner;

public class MSS {
    static long INF = (long) 1e13;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            String s = sc.next();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                if(s.charAt(i) == '0'){
                    arr[i] = -INF;
                }else{
                    arr[i] = val;
                }
            }
            long is = kadane(arr);
            if(is > k){
                System.out.println("No");
                continue;
            }else if(is == k){
                System.out.println("Yes");
                for(int i=0;i<n;i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                continue;
            }
            int pos = -1;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '0'){
                    pos = i;
                    break;
                }
            }
            if(pos == -1){
                System.out.println("No");
                continue;
            }
            long l = 0;
            long sum = 0;
            for(int i = pos-1; i >= 0; i--){
                sum += arr[i];
                l = Math.max(l,sum);
            }
            long r = 0;
            sum = 0;
            for(int i = pos+1; i < n; i++){
                sum += arr[i];
                r = Math.max(r,sum);
            }
            long req = k - l - r;
            System.out.println("Yes");
            for(int i = 0; i < n; i++){
                if(i == pos){
                    System.out.print(req + " ");
                }else System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    private static long kadane(long[] arr){
        long ans=  0;
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum < 0)sum = 0;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
