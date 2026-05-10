import java.util.Scanner;

public class RudolfAndSnowflakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            if(n < 7){
                System.out.println("NO");
                continue;
            }
            boolean valid = false;

            //max depth will be 20 because if we take min k = 2 then in eacj level nodes are doubling so 2 ki power 20 > 1000000
            for(int depth = 2; depth <= 20; depth++){

                int l = 2;
                int r = n;
                while(l <= r){
                    int mid = l + (r - l) / 2;
                    int kyahua = isPossibleInThisDepth(mid,n,depth);
                    if(kyahua == 1){
                        r = mid-1;
                    }else if(kyahua == -1){
                        l = mid+1;
                    }else{
                        valid = true;
                        break;
                    }
                }
                if(valid)break;
            }
            if(valid)System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static int isPossibleInThisDepth(long k, long n, int depth){

        long mul = 1;
        long total = 1;

        while(depth-- > 0){

            if(mul > n / k) return 1; // overflow ya definitely bigger

            mul *= k;
            total += mul;

            if(total > n) return 1;
        }

        if(total < n) return -1;

        return 0;
    }
}
