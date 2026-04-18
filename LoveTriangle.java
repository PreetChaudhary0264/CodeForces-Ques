import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LoveTriangle {
    public static void main(String[] args) throws IOException {
        FastReaderL fr = new FastReaderL();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        boolean exist = false;
        for(int i = 0; i < n; i++){
            int val1 = arr[i] - 1;
            int val2 = arr[val1] - 1;
            int val3 = arr[val2] - 1;

            if(i == val3){
                exist = true;
                break;
            }
        }
        if(exist) System.out.println("YES");
        else System.out.println("NO");
    }
}

class FastReaderL {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderL() {
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
