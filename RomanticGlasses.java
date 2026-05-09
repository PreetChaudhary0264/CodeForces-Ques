import java.util.HashMap;
import java.util.Scanner;

public class RomanticGlasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            HashMap<Long,Integer> diff = new HashMap<>();
            diff.put(0L,-1);
            boolean valid = false;
            long juice = 0;
            for(int i = 0; i < n; i++){
                if(i % 2 == 0)juice += a[i];
                else juice -= a[i];
                if(diff.containsKey(juice)){
                    valid = true;
                    break;
                }
                diff.put(juice,i);
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
