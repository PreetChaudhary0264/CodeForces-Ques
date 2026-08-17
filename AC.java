import java.util.Scanner;

public class AC {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') zeros++;
                else ones++;
            }
            if (Math.abs(zeros - ones) > 2) {
                System.out.println(-1);
                continue;
            }
            int iniSubLen = 1;
            int iniSub0 = (s.charAt(0) == '0') ? 1 : 0;
            int iniSub1 = (s.charAt(0) == '1') ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    iniSubLen++;
                    if (s.charAt(i) == '0') iniSub0++;
                    else iniSub1++;
                }
            }
            int d0 = zeros - iniSub0;
            int d1 = ones - iniSub1;
            int diff = Math.abs(d0 - d1);
            int extra = Math.max(0, diff - 1);
            System.out.println(n-iniSubLen+extra);
        }
    }
}