import java.util.Scanner;

public class PFD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
            if(n < 3){
                System.out.println("No");
                continue;
            }
            int c1 = 0;
            int c3 = 0;
            int[] p1 = new int[n];
            int[] p3 = new int[n];
            for(int i = 0; i < n; i++){
                if(arr[i] == 1) c1++;
                else if(arr[i] == 3) c3++;

                p1[i] = c1;
                p3[i] = c3;
            }
            int[] pc = new int[n];
            for(int i = 0; i < n; i++){
                pc[i] = 2 * p3[i] - i;
            }
            int[] sm = new int[n];
            sm[n-2] = pc[n-2];
            for(int i = n-3; i >= 0; i--){
                sm[i] = Math.min(pc[i],sm[i+1]);
            }

            boolean ans = false;
            for(int i = 0; i < n - 2; i++){
                if(p1[i] >= (i+2)/2){
                    if(pc[i] >= sm[i+1]){
                        ans = true;
                        break;
                    }
                }
            }
            if(ans) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}
