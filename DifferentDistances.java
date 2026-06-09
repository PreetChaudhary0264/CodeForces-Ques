import java.util.Scanner;

public class DifferentDistances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            for(int i = 1; i <= n; i++){
                System.out.print(i + " ");
            }
            for(int i = 1; i <= n; i++){
                System.out.print(i + " " + i + " ");
            }
            for(int i = n-1; i >= 1; i--){
                System.out.print(i + " ");
            }
            System.out.print(n);
            System.out.println();
        }
    }
}
