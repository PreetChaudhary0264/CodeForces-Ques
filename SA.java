import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SA{
    static class FastReaderM4{
        BufferedReader br;
        StringTokenizer st;
        public FastReaderM4(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException{
            while(st==null||!st.hasMoreElements()){
                st=new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
        String nextLine() throws IOException{
            return br.readLine();
        }
    }
    public static void main(String[] args) throws IOException{
        FastReaderM4 sc =new FastReaderM4();
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int s = sc.nextInt();
            String line = sc.next();
            int[] dp = new int[x+1];
            Arrays.fill(dp,-1);
            dp[0] = 0;
            for(int i = 0; i < n; i++){
                char ch = line.charAt(i);
                for(int j = x; j >= 0; j--){
                    if(dp[j] == -1)continue;
                    int seated = dp[j];
                    int rem = (j * s) - seated;

                    if(ch == 'I'){
                        if(j < x){
//                            dp[j+1] = seated+1;
                            dp[j+1] = Math.max(dp[j+1],seated+1);
                        }
                    }else if(ch == 'E'){
                        if(rem > 0){
                            dp[j] = Math.max(dp[j], seated+1);
                        }
                    }else{
                        if(rem > 0){
                            dp[j] = Math.max(dp[j], seated+1);
                        }
                        if(j < x){
                            dp[j+1] = Math.max(dp[j+1],seated+1);
                        }
                    }
                }
            }
//            System.out.println(dp[x]);
            int ans = 0;
            for(int i = 0; i <= x; i++){
                ans = Math.max(ans, dp[i]);
            }
            System.out.println(ans);
        }
    }
}
