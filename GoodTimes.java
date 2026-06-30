import java.util.Scanner;

public class GoodTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int x = sc.nextInt();
            int d = 0;
            while(x > 0){
                d++;
                x /= 10;
            }
            long n = 10;
            for(int i = 0; i < d-1; i++){
                n = n * 10;
            }
            n += 1;
            System.out.println(n);
        }
    }
}
