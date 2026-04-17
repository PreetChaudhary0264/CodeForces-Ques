import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class DestroyingBridges {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        while(test-- > 0){
            int n = fr.nextInt();
            int k = fr.nextInt();

            if(k >= n-1){
                System.out.println(1);
            }else{
                System.out.println(n);
            }
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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