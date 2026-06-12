import java.util.Scanner;

public class TatarTvShow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] s = sc.next().toCharArray();
            boolean valid = true;
            for(int i = 0; i < (n-k); i++){
                if(s[i] == '1'){
                    s[i] = '0';
                    s[i+k] = (s[i+k] == '0') ? '1' : '0';
                }
            }
            for(int i = 0; i < n; i++){
                if(s[i] == '1'){
                    valid = false;
                    break;
                }
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
