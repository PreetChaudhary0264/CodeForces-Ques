import java.util.*;

public class Tree67Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int n = x + y;

            if((n % 2 == 0 && x == 0) || (n % 2 != 0 && y == 0)){
                System.out.println("NO");
                continue;
            }

            if(n % 2 == 0) x--;
            else y--;

            if(x > y){
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            int node = 2;
            List<int[]> evenPlusOdd = new ArrayList<>();
            List<int[]> ans = new ArrayList<>();

            for(int i = 0; i < x; i++){
                int u = node++;
                int v = node++;
                evenPlusOdd.add(new int[]{u,v});
                ans.add(new int[]{u,v});
                y--;
            }

            for(int[] p : evenPlusOdd){
                ans.add(new int[]{1,p[0]});
            }

            while(node <= n){
                ans.add(new int[]{1,node});
                node++;
            }

            for(int[] p : ans){
                System.out.println(p[0] + " " + p[1]);
            }
        }
    }
}
