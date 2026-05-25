import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SuffixArray1 {

    static class FastReaderSA {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderSA() {
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
    static class Entry{
        int first;
        int second;
        int index;
        Entry(int f,int s,int i){
            this.first = f;
            this.second = s;
            this.index = i;
        }
    }
    public static void main(String[] args) throws IOException {
        FastReaderSA sc = new FastReaderSA();
        String s = sc.next();
        s = s + "$";
        int n = s.length();

        int maxLog = (int) ((Math.log(n) / Math.log(2)) + 2);
        int[][] rank = new int[maxLog][n];
        for(int i = 0; i < n; i++){
            rank[0][i] = s.charAt(i);  //single characters ko unki ascii value se store kr liya
        }
        int len = 1;
        int step = 1;
        Entry[] entries = new Entry[n];
        while(len < n){
            for(int i = 0; i < n; i++){
                int first = rank[step-1][i];
                int second = i + len < n ? rank[step-1][i+len] : -1;
                entries[i] = new Entry(first,second,i);
            }
            Arrays.sort(entries,(a,b)-> {
                if(a.first != b.first)return Integer.compare(a.first,b.first);
                return Integer.compare(a.second,b.second);
            });
            int newRank = 0;
            rank[step][entries[0].index] = 0;
            for(int i = 1; i < n; i++){
                if(entries[i].first != entries[i-1].first || entries[i].second != entries[i-1].second){
                    newRank++;
                }
                rank[step][entries[i].index] = newRank;
            }
            step++;
            len = len << 1;
        }
        Integer[] order = new Integer[n];
        for(int i = 0; i <n ; i++)order[i] = i;
        int finalStep = step-1;
        Arrays.sort(order,(a,b)-> Integer.compare(rank[finalStep][a], rank[finalStep][b]));
        for(int i = 0; i < n; i++){
            System.out.println(order[i]);
        }
    }
}
