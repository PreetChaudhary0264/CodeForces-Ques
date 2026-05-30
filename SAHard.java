import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SAHard{
    static class FastReaderM4{
        BufferedReader br;
        StringTokenizer st;
        public FastReaderM4(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException{
            while(st==null||!st.hasMoreElements()){
                st=new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
        String nextLine() throws IOException{
            return br.readLine();
        }
    }
    public static void main(String[] args) throws IOException{
        FastReaderM4 sc =new FastReaderM4();
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int s = sc.nextInt();
            String line = sc.next();
            int tu = 0;
            long ts = 0;
            int seated = 0;
            int usedA = 0;
            for(int i = 0; i < n; i++){
                char ch = line.charAt(i);
                if(ch == 'I'){
                    if(tu < x){
                        tu++;
                        ts += (s-1);
                        seated++;
                    }
                }else if(ch == 'A'){
                    if(ts > 0){
                        ts--;
                        seated++;
                        usedA++;
                    }else if(tu < x){
                        tu++;
                        seated++;
                        ts += (s-1);
                    }
                }else{
                    if(ts > 0){
                        ts--;
                        seated++;
                    }else{
                        if(tu < x && usedA > 0){
                            usedA--;
                            tu++;
                            seated++;
                            ts += (s-1);
                        }
                    }
                }
            }
            System.out.println(seated);
        }
    }
}
