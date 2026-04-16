import java.util.Scanner;

public class AntimedianDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            if(n == 1){
                System.out.println(1);
            }else{
                for(int i = 0; i < n; i++){
                    System.out.print(2 + " ");
                }
                System.out.println();
            }
        }
    }
}
