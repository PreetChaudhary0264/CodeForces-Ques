import java.util.*;

public class ASP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int maxDiff = -1;
            for(int i = 0; i < n-1; i++){
                if(a[i] > a[i+1]){
                    maxDiff = Math.max(maxDiff,a[i]-a[i+1]);
                }
            }
            boolean valid = true;
            for(int i = 1; i < n; i++){
                if(a[i] < a[i-1]){
                    a[i] += maxDiff;
                    if(a[i] < a[i-1]){
                        valid = false;
                        break;
                    }
                }
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
