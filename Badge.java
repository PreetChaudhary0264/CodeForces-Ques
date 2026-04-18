import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Badge {
    public static void main(String[] args) throws IOException {
        FastReaderB fr = new FastReaderB();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fr.nextInt();
        }
        for(int i = 0; i < n; i++){
            int[] freq = new int[n];
            int j = i;

            while(true){
                freq[j]++;
                if(freq[j] == 2){
                    System.out.print(j+1 + " ");
                    break;
                }
                j = arr[j] - 1;
            }
        }
        System.out.println();
    }
}

class FastReaderB {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderB() {
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

