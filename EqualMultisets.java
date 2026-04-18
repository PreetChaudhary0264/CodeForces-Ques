import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class EqualMultisets {
    public static void main(String[] args) throws IOException {
        FastReaderMU fr = new FastReaderMU();
        int test = fr.nextInt();
        while(test-- > 0){
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = fr.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            boolean duplicates = false;
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = fr.nextInt();
                if(set.contains(b[i]))duplicates = true;
                if(b[i] != -1)set.add(b[i]);
            }
            if(duplicates){
                System.out.println("NO");
            }else if(k == n){
                System.out.println("YES");
            }else{
                set = new HashSet<>();
                HashSet<Integer> set2 = new HashSet<>();
                for(int i = k-1; i >= 0; i--){
                    if(b[i] != -1)set.add(b[i]);
                    set2.add(a[i]);
                }
                int j = k-1;
                int i = k-1;
                for(; i >= 0 && j >= 0; ){
                    if(a[i] == b[j] || (set.contains(a[i]) && set2.contains(b[j]))){
                        i--;
                        j--;
                    }else if(set.contains(a[i])) {
                        i--;
                    }else if(set2.contains(b[j])){
                        j--;
                    }else if(b[j] != -1 && !set2.contains(b[j])){
                        break;
                    }else{
                        b[j] = a[i];
                        j--;
                        i--;
                    }
                }
                if(i > -1 && j > -1){
                    System.out.println("NO");
                }else{
//                    System.out.println(Arrays.toString(b));
                    int z = 0;
                    boolean valid = true;
                    for(int x = k; x < n; x++){
                        if(!valid)break;
                        if(b[x] != -1 && b[x] != a[x]){
                            valid = false;
                            break;
                        }
                        b[x] = a[x];
                        if(a[z] != b[z]){
                            valid = false;
                        }
                        z++;
                    }
                    if(valid) System.out.println("YES");
                    else System.out.println("NO");
                }
            }
        }
    }
}
class FastReaderMU {
    BufferedReader br;
    StringTokenizer st;

    public FastReaderMU() {
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


