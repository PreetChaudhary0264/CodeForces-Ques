import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IvaAndPva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int q = sc.nextInt();
            List<int[]> queries = new ArrayList<>();
            for(int i = 0; i < q; i++){
                int l = sc.nextInt();
                int k = sc.nextInt();
                queries.add(new int[]{l,k});
            }
            int[][] prefix = new int[n][32];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < 32; j++){
                    int bit = (a[i] >> j) & 1;
                    prefix[i][j] = bit + ((i-1 >= 0) ? prefix[i-1][j] : 0);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < q; i++){
                int l = queries.get(i)[0] - 1;
                int k = queries.get(i)[1];

                int left = l;
                int right = n-1;
                int res = -1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(possible(prefix,mid,l,k)){
                        res = mid + 1;
                        left = mid + 1;
                    }else{
                        right = mid-1;
                    }
                }
                ans.add(res);
            }
            for(int i = 0; i < ans.size(); i++){
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
    private static boolean possible(int[][] prefix,int mid,int l,int k){
        long ans = 0;
        int len = mid - l + 1;
        for(int i = 0; i < 32; i++){
            int cnt = prefix[mid][i] - ((l-1 >= 0) ? prefix[l-1][i] : 0);
            if(cnt == len){
                ans = ans | (1L << i);
            }
        }
        return ans >= k;
    }
}