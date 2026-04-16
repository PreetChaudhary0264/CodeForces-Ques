import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                int smallest = 0;
                int largest = 0;
                for(int j = i+1; j < n; j++){
                    if(arr[j] < arr[i])smallest++;
                    else if(arr[j] > arr[i])largest++;
                }
                System.out.print(Math.max(smallest,largest) + " ");
            }
            System.out.println();
        }
    }
}