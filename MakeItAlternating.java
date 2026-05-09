import java.util.Scanner;

public class MakeItAlternating {

    static final long MOD = 998244353;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while(test-- > 0){

            String s = sc.next();

            int n = s.length();

            long ways = 1;
            long deletions = 0;

            int i = 0;

            while(i < n){

                int j = i;

                while(j + 1 < n && s.charAt(j) == s.charAt(j + 1)){
                    j++;
                }

                int len = j - i + 1;

                deletions += (len - 1);

                ways = (ways * len) % MOD;

                i = j + 1;
            }

            for(long k = 1; k <= deletions; k++){
                ways = (ways * k) % MOD;
            }

            System.out.println(deletions + " " + ways);
        }
    }
}
