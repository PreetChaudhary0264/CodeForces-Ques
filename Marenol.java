import java.util.Scanner;

public class Marenol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            String t = sc.next();

            int ae = 0,ao = 0;
            int be = 0,bo = 0;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '1'){
                    if(i % 2 == 0)ae++;
                    else ao++;
                }
                if(t.charAt(i) == '1'){
                    if(i % 2 == 0)be++;
                    else bo++;
                }
            }
            if(ae == be && ao == bo) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
