import java.util.Arrays;
import java.util.Scanner;

public class SmiloAndMonsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++)arr[i] = sc.nextLong();
            Arrays.sort(arr);
            int i = 0;
            int j = n-1;
            long maxVal = arr[n-1];
            long attacks = 0;
            long x = 0;
            while(i <= j){
                if(i == j){
                    if(arr[i] == 1)attacks++;
                    else{
                        long diff = arr[j] - x;
                        attacks += ((int)Math.ceil((double) diff / 2)) + 1;
                    }
                    i++;
                    j--;
                }else{
                    long canTake = Math.min(arr[i],maxVal - x);
                    attacks += canTake;
                    arr[i] -= canTake;
                    x += canTake;
                    if(arr[i] == 0)i++;
                    if(x >= maxVal) {
                        attacks++;
                        j--;
                        x = 0;
                        maxVal = arr[j];
                    }
                }
            }
            System.out.println(attacks);
        }
    }
}
