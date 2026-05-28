import java.util.Arrays;
import java.util.Scanner;

public class Dances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            sc.nextInt();
            int[] a = new int[n];
            a[0] = 1;
            for(int i = 1; i < n; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            int i = 0;
            int j = 0;
            int c = 0;
            while(i < n && j < n){
                if(a[i] < b[j]){
                    c++;
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            System.out.println(n-c);
        }
    }
}
