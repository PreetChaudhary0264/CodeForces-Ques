import java.util.Arrays;
import java.util.Scanner;

public class OneNightAtFreedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();

            int[] arr = new int[n];
            for(int i =0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int[] danger = new int[m];
            int curr = n;
            for(int i = 0; i < l; i++){
                int idx = Math.min(m,curr+1)-1;
                danger[idx]++;

                Arrays.sort(danger);
                reverse(danger);

                if(curr > 0 && arr[n-curr]-1 == i){
                    danger[0] = 0;
                    curr--;
                    Arrays.sort(danger);
                    reverse(danger);
                }
            }
            System.out.println(danger[0]);
        }
    }
    static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
