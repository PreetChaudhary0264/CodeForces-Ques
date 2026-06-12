import java.util.Scanner;

public class GamesTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] ar = new int[n];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                ar[i] = sc.nextInt();
                max = Math.max(max,ar[i]);
                min = Math.min(min,ar[i]);
            }
            System.out.println(max-min+1);
        }
    }
}
