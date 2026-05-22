import java.util.*;

public class MoveAndTurn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        if(n % 2 == 0){
            long k = n / 2;
            System.out.println((k + 1) * (k + 1));
        }else{
            long a = (n + 1) / 2;
            long b = (n + 3) / 2;
            System.out.println(2 * a * b);
        }
    }
}
