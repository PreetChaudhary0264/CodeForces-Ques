import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SubstringSearch {

    static class FastReaderSS {
        BufferedReader br;
        StringTokenizer st;

        public FastReaderSS() {
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
        FastReaderSS sc = new FastReaderSS();
        String t = sc.next();
        int n = sc.nextInt();
        List<String> queries = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            queries.add(s);
        }
        int[] suffix = buildSuffix(t);
        for(String query : queries){
            boolean ans = contains(t,suffix,query);
            if(ans){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    static boolean contains(String t, int[] sa, String pat) {
        int l = 0;
        int r = sa.length - 1;

        while (l <= r) {
            int mid = (l + r) >>> 1;

            int cmp = compare(t, sa[mid], pat);

            if (cmp == 0)
                return true;

            if (cmp < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }

    static int compare(String t, int pos, String pat) {
        int n = t.length();
        int m = pat.length();

        for (int i = 0; i < m; i++) {
            if (pos + i >= n)
                return -1;

            char a = t.charAt(pos + i);
            char b = pat.charAt(i);

            if (a < b) return -1;
            if (a > b) return 1;
        }

        return 0;
    }

    private static int[] buildSuffix(String s){
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
            Arrays.sort(entries,(a, b)-> {
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
        int[] suffix = new int[n];
        for(int i = 0; i < n; i++){
            suffix[i] = order[i];
        }
        return suffix;
    }
}
