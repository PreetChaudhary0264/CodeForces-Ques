import java.util.Scanner;

public class FlipTheBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int p = sc.nextInt()-1;
            int start = -1;
            int end = -1;
            for(int i = 0; i < p; i++){
                if(arr[i] != arr[p]){
                    start = i;
                    break;
                }
            }
            for(int i = n-1; i > p; i--){
                if(arr[i] != arr[p]){
                    end = i;
                    break;
                }
            }
            int leftSegments = 0;
            if(start != -1){
                for(int i = start+1; i < p; i++){
                    if(arr[i] != arr[i-1])leftSegments++;
                }
            }
            if(start != -1)leftSegments++;
            int rightSegments = 0;
            if(end != -1){
                for(int i = p+1; i <= end; i++){
                    if(arr[i] != arr[i-1])rightSegments++;
                }
            }
            if(end != -1)rightSegments++;
            int ans = Math.max(leftSegments,rightSegments);
            ans = (ans % 2 == 1) ? ans + 1 : ans;
            System.out.println(ans);
        }
    }
}
