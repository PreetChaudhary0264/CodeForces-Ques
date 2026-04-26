import java.io.*;

public class Invert {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();

            int i = 1;
            boolean one = false;
            boolean valid = true;
            while(i < n){
                if(s.charAt(i) == s.charAt(i-1)){
                    if(one){
                        valid = false;
                        break;
                    }
                    int start = i;
                    while(i + 1 < n && s.charAt(i) == s.charAt(i+1)){  //check eual chars like bbb
                        i++;
                    }
                    int diff = i - start;
                    if(diff >= 2){  //yani same char ki length 3 se jyada hai bbbb not possible
                        valid = false;
                        break;
                    }
                    if(diff == 0){
                        while(i + 1 < n && s.charAt(i) != s.charAt(i+1)){  //now check max alternating
                            i++;
                        }
                    }
                    one = true;
                    i += 2;
                }else{
                    i++;
                }
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}