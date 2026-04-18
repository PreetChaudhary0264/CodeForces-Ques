import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GregorAndThePawn {
    public static void main(String[] args) throws IOException {
        FastReaderg fr = new FastReaderg();
        int test = fr.nextInt();
        while(test-- > 0){
            int n = fr.nextInt();
            char[] enemy = fr.next().toCharArray();
            String george = fr.next();

            int c = 0;
            for(int i = 0; i < n; i++){
                char ch1 = enemy[i];
                char ch2 = george.charAt(i);
                if(ch2 == '1'){
                    if(ch1 == '0')c++;
                    else{
                        if(i-1 >= 0 && enemy[i-1] == '1'){
                            enemy[i-1] = '#';
                            c++;
                        }else if(i+1 < n && enemy[i+1] == '1'){
                            enemy[i+1] = '#';
                            c++;
                        }
                    }
                }
            }
            System.out.println(c);
        }
    }
}

class FastReaderg {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderg() {
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

