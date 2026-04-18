import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LiHuaAndMaze {
    public static void main(String[] args) throws IOException {
        FastReaderR fr = new FastReaderR();
        int test = fr.nextInt();
        while(test-- > 0){
            int n = fr.nextInt();
            int m = fr.nextInt();
            int x1 = fr.nextInt() - 1;
            int y1 = fr.nextInt() - 1;
            int x2 = fr.nextInt() - 1;
            int y2 = fr.nextInt() - 1;

            int deg1 = 4;
            if(x1 == 0 || x1 == n-1) deg1--;
            if(y1 == 0 || y1 == m-1) deg1--;

            int deg2 = 4;
            if(x2 == 0 || x2 == n-1) deg2--;
            if(y2 == 0 || y2 == m-1) deg2--;

            System.out.println(Math.min(deg1, deg2));
        }
    }
}
class FastReaderR {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderR() {
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
