import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class KAmazingNumber {
    static class FastReaderM88 {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderM88() {
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
        FastReaderM88 sc = new FastReaderM88();
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            HashMap<Integer,Integer> values = new HashMap<>();
            int[] arr = new int[300010];
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                int diff = (i+1) - arr[val];
                if(values.containsKey(val)){
                    int d = values.get(val);
                    if(diff > d)values.put(val,diff);
                }else{
                    values.put(val,diff);
                }
                arr[val] = i+1;
            }
            for(int key : values.keySet()){
                int diff = (n+1) - (arr[key]);
                int gap = values.get(key);
                if(diff > gap){
                    values.put(key,diff);
                }
            }
            int[] ans = new int[n];
            Map<Integer,Integer> gaps = new HashMap<>();
            for(int key : values.keySet()){
                int val = values.get(key);
                if(gaps.containsKey(val)){
                    int v = gaps.get(val);
                    if(key < v)gaps.put(val,key);
                }else{
                    gaps.put(val,key);
                }
            }
            int res = -1;
            for(int i = 0; i < n; i++){
                int gap = i+1;
                if(gaps.containsKey(gap)){
                    int val = gaps.get(gap);
                    if(res == -1)res = val;
                    else{
                        res = Math.min(res,val);
                    }
                }
                ans[i] = res;
            }
            for(int i = 0; i < n; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
