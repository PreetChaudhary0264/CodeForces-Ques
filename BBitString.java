import java.util.Scanner;

public class BBitString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] s = sc.next().toCharArray();
            boolean possible = true;
            valid:for (int i = 0; i < k; i++) {
                char ch = '?';

                for (int j = i; j < n; j += k) {
                    if (s[j] == '?') continue;

                    if (ch == '?') {
                        ch = s[j];
                    } else if (ch != s[j]) {
                        System.out.println("No");
                        possible = false;
                        break valid;
                    }
                }

                if (ch != '?') {
                    for (int j = i; j < n; j += k) {
                        s[j] = ch;
                    }
                }
            }
            if(!possible){
                continue;
            }
            int one = 0;
            int zero = 0;
            int qm = 0;
            for(int i = 0; i < k; i++){
                if(s[i] == '0')zero++;
                else if(s[i] == '1')one++;
                else qm++;
            }
            if(one > (k/2) || zero > (k/2)){
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }
    }
}
