import java.util.Scanner;

public class RV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int remChars = 0;
            for(int i = 1; i < n; i++){
                char ch = s.charAt(i);
                char prev = s.charAt(i-1);
                if(ch != prev)remChars++;
            }
            remChars++;
            if(remChars == 1) System.out.println(1);
            else if(remChars == 2) System.out.println(2);
            else System.out.println(1);
        }
    }
}
