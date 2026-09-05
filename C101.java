import java.util.Scanner;

public class C101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)arr[i] = sc.nextInt();
            for(int i = 0; i < n; i++){
                if(arr[i] == 1)break;
                if(arr[i] == -1){
                    arr[i] = 1;
                    break;
                }
            }
            for(int i = n-1; i >= 0; i--){
                if(arr[i] == 1)break;
                if(arr[i] == -1){
                    arr[i] = 1;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(arr[i] == -1)arr[i] = 0;
            }
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
