import java.util.*;

public class CCTD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < n-1; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.add(new int[]{u,v});
            }
            Set<Integer> seen = new HashSet<>();
//            seen.add(1);
            int[] dp = new int[n-1];
            for(int i = 0; i < n-1; i++){
                int u = list.get(i)[0];
                int v = list.get(i)[1];
                if(seen.contains(u) || seen.contains(v)){
                    dp[i] = (i-1 >= 0 ? dp[i-1] : 0);
                    if(!seen.contains(u))seen.add(u);
                    if(!seen.contains(v))seen.add(v);
                }else{
                    dp[i] = (i-1 >= 0 ? dp[i-1] + 1 : 1);
                    seen.add(u);
                    seen.add(v);
                }
            }
//            System.out.println(Arrays.toString(dp));
            System.out.println(dp[n-2]);
        }
    }
}
