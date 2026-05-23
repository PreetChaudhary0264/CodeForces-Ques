import java.util.Arrays;
import java.util.Scanner;

public class AnnaAndValentineDayGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] trailZeros = new int[n];
            int totalDigits = 0;
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();

                while(num % 10 == 0){
                    trailZeros[i]++;
                    num /= 10;
                    totalDigits++;
                }
                while(num > 0){
                    totalDigits++;
                    num /= 10;
                }
            }
            Arrays.sort(trailZeros);
            for(int i = n-1; i >= 0; i-=2){
                totalDigits -= trailZeros[i];
            }
            if(totalDigits > m) System.out.println("Sasha");
            else System.out.println("Anna");
        }
    }
}
