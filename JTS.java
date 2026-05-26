import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JTS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                list.add(new int[]{l,r});
            }
            int l = 0;
            int r = (int)1e9;
            int ans = 0;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(check(list,mid)){
                    ans = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    private static boolean check(List<int[]> list, int k) {
        long L = 0;
        long R = 0;

        for (int[] seg : list) {
            L -= k;
            R += k;

            L = Math.max(L, seg[0]);
            R = Math.min(R, seg[1]);

            if (L > R) return false;
        }

        return true;
    }
}
