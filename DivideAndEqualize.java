import java.util.HashMap;
import java.util.Scanner;

public class DivideAndEqualize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            HashMap<Integer,Integer> primeFactors = new HashMap<>();
            for(int i = 0; i < n; i++){
                for(int j = 2; j * j <= a[i]; j++){
                    while(a[i] % j == 0){
                        primeFactors.put(j,primeFactors.getOrDefault(j,0)+1);
                        a[i] /= j;
                    }
                }
                if(a[i] > 1)primeFactors.put(a[i],primeFactors.getOrDefault(a[i],0)+1);
            }
            boolean valid = true;
            for(int val : primeFactors.values()){
                if(val % n != 0){
                    valid = false;
                    break;
                }
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
