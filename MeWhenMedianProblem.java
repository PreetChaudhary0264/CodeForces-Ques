import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MeWhenMedianProblem {

    static class FastReaderMWMP {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderMWMP() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
    public static void main(String[] args) throws IOException {
        FastReaderMWMP sc = new FastReaderMWMP();
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                min = Math.min(min,a[i]);
                max = Math.max(max,a[i]);
            }
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = sc.nextInt();
                min = Math.min(min,b[i]);
                max = Math.max(max,b[i]);
            }
            int ans = 0;
            int l = min;
            int r = max;
            while(l <= r){
                int mid = l + (r - l) / 2;

                int ones = 0;
                int zeros = 0;
                int prev = -1;
                for(int i = 0; i < n; i++){
                    int type = 0;
                    if(a[i] >= mid)type++;
                    if(b[i] >= mid)type++;

                    if(type == 1)continue;  //0,1 wala case
                    if(type == 2){
                        ones++;
                        prev = 1;
                    }
                    if(type == 0){
                        if(prev != 0){
                            zeros++;
                        }
                        prev = 0;
                    }
                }
                if(ones > zeros){
                    ans = mid;
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
}
