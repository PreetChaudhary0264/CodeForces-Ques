import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BracketColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int ob = 0;
            int cb = 0;
            for(char ch  :s.toCharArray()){
                if(ch == '(')ob++;
                else cb++;
            }
            if(ob != cb){
                System.out.println(-1);
            }else{
                int bal = 0;
                int mn = 0, mx = 0;

                for(int i = 0; i < n; i++){
                    bal += (s.charAt(i) == '(' ? 1 : -1);
                    mn = Math.min(mn, bal);
                    mx = Math.max(mx, bal);
                }

                if(mn >= 0 || mx <= 0){
                    System.out.println(1);
                    for(int i = 0; i < n; i++) System.out.print("1 ");
                    System.out.println();
                }else{
                    int[] colors = new int[n];
                    bal = 0;

                    for(int i = 0; i < n; i++){
                        if(s.charAt(i) == '('){
                            bal++;
                            colors[i] = (bal > 0 ? 1 : 2);
                        }else{
                            colors[i] = (bal > 0 ? 1 : 2);
                            bal--;
                        }
                    }

                    System.out.println(2);
                    for(int x : colors) System.out.print(x + " ");
                    System.out.println();
                }
            }
        }
    }
}
