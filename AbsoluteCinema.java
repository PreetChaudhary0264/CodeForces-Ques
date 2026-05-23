import java.util.Scanner;

public class AbsoluteCinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            long ans = 0;
            for(int i = 0; i < n; i++){
                if(a[i] > b[i]){
                    ans += a[i];
                    int temp = a[i];
                    a[i] = b[i];
                    b[i] = temp;
                }else{
                    ans += b[i];
                }
            }
            int maxVal = 0;
            for(int i = 0; i < n; i++){
                maxVal = Math.max(maxVal,a[i]);
            }
            ans += maxVal;
            System.out.println(ans);
        }
    }
}
