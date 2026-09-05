import java.util.Scanner;

public class Moo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int odds = 0;
            int evenZeros = 0;
            int evenTwos = 0;

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a % 2 != 0) {
                    odds++;
                } else if (a % 4 == 0) {
                    evenZeros++;
                } else {
                    evenTwos++;
                }
            }

            int maxFreq = Math.max(odds, Math.max(evenZeros, evenTwos));
            System.out.println(maxFreq);
        }
    }
}