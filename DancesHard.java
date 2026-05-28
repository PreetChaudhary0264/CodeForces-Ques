import java.util.Arrays;
import java.util.Scanner;

public class DancesHard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n-1];
            for(int i = 0; i < n-1; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            boolean[] visited = new boolean[n];
            int pairs = 0;
            int i = 0;
            int j = 0;
            while(i < n-1 && j < n){
                if(a[i] < b[j]){
                    pairs++;
                    visited[j] = true;
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
//            System.out.println(pairs);
//            System.out.println(Arrays.toString(visited));
            long total = (long) m * n;
            int grVal = 0;
            for(int l = n-1; l >= 0; l--){
                if(!visited[l]){
                    grVal = b[l];
                    break;
                }
            }
//            System.out.println(grVal);
            int epossible = Math.min(grVal-1,m);
//            System.out.println(epossible);
            long extra = (long) (pairs+1) * epossible;
            long less = (long) pairs * (m - epossible);
            long ans = total - (extra + less);
            System.out.println(ans);
        }
    }
}
