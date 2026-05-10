import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrongVertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            int[] diff = new int[n];
            int maxDiff = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                int d = a[i] - b[i];
                diff[i] = d;
                maxDiff = Math.max(maxDiff,d);
            }
            int c = 0;
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(diff[i] == maxDiff){
                    c++;
                    ans.add(i+1);
                }
            }
            System.out.println(c);
            for(int i = 0; i < ans.size(); i++){
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
