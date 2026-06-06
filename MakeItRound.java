import java.util.Scanner;

public class MakeItRound {
    static long[] p2 = new long[19];
    static long[] p5 = new long[19];

    static {
        p2[0] = 1;
        p5[0] = 1;
        for(int i = 1; i <= 18; i++){
            p2[i] = p2[i-1] * 2;
            p5[i] = p5[i-1] * 5;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int p2c = 0;
            long temp = n;
            while(temp % 2 == 0) {
                p2c++;
                temp /= 2;
            }
            int p5c = 0;
            temp = n;
            while(temp % 5 == 0) {
                p5c++;
                temp /= 5;
            }
            long ans = 0;
            for(int dig = 18; dig >= 0; dig--){
                int extra2 = Math.max(0,dig - p2c);
                int extra5 = Math.max(0, dig - p5c);


            }
        }
    }
}
