import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Metro {
    public static void main(String[] args) throws IOException {
        FastReaderM fr=  new FastReaderM();
        int n = fr.nextInt();
        int s = fr.nextInt() - 1;
        int[] forward = new int[n];
        for(int i = 0; i < n; i++){
            forward[i] = fr.nextInt();
        }
        int[] reverse = new int[n];
        for(int i = 0; i < n; i++){
            reverse[i] = fr.nextInt();
        }
        if(forward[0] == 0 || (forward[s] == 0 && reverse[s] == 0)){
            System.out.println("NO");
        }else if(forward[0] == 1 && forward[s] == 1){
            System.out.println("YES");
        }else{
            boolean valid = false;
            for(int i = s+1; i < n; i++){
                if(forward[i] == 1 && reverse[i] == 1){
                    valid = true;
                    break;
                }
            }
            if(valid && reverse[s] == 1) System.out.println("Yes");
            else System.out.println("NO");
        }
    }
}

class FastReaderM {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderM() {
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


