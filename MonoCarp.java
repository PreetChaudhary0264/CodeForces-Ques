import java.util.Scanner;

public class MonoCarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int c = 0;
            int tz = 0;
            for(int i  =0; i < n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] == 0)tz++;
                if(i == 0 || i == n-1){
                    if(arr[i] == 0)c++;
                }
            }
            if(tz < 2){
                System.out.println(-1);
                continue;
            }
            if(c == 2) System.out.println(0);
            else if(c == 1) System.out.println(1);
            else System.out.println(2);
        }
    }
}
