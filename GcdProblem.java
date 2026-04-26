import java.util.Scanner;

public class GcdProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                sc.nextInt();
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                if(i == 0){
                    int A = gcd(a[0],a[i+1]);
                    if(A < a[0])count++;
                }else if(i == n-1){
                    int A = gcd(a[n-1],a[n-2]);
                    if(A < a[n-1])count++;
                }else{
                    int A = gcd(a[i],a[i-1]);
                    int B = gcd(a[i],a[i+1]);

                    long lcm = (long) A * B / gcd(A,B);

                    if(lcm < a[i])count++;
                }
            }
            System.out.println(count);
        }
    }
    private static int gcd(int a,int b){
        if(b == 0)return a;
        return gcd(b, a % b);
    }
}
