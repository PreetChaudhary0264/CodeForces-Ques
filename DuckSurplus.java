import java.util.Scanner;

public class DuckSurplus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i  =0; i < n; i++)arr[i] = sc.nextInt();
            long maxVal = 0;
            for(int i = 0; i < n; i++){
                maxVal = Math.max(maxVal,arr[i]);
                if(arr[i] < maxVal)maxVal += arr[i];
            }
            System.out.println(maxVal);
        }
    }
}
