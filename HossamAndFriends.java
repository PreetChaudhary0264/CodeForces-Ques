import java.util.Arrays;
import java.util.Scanner;

public class HossamAndFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nn = new int[n+1];
            for(int i = 0; i < m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x > y){
                    int temp = x;
                    x = y;
                    y = temp;
                }

                if(x > nn[y])nn[y] = x;
            }
            for(int i = 1; i <= n; i++){
//                if(nn[i] == 0){
//                    nn[i] = nn[i-1];
//                }
                nn[i] = Math.max(nn[i],nn[i-1]);
            }
//            System.out.println(Arrays.toString(nn));
            long ans = 0;
            for(int i = 1; i <= n; i++){
                int len = i - (nn[i]);
                ans += len;
            }
            System.out.println(ans);
        }
    }
}
