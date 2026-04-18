import java.util.Scanner;

public class NewYearTransportation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n-1; i++){
            a[i] = sc.nextInt();  // no -1
        }

        int curr = 0;

        while(curr < t-1){
            curr = curr + a[curr];
        }

        if(curr == t-1) System.out.println("YES");
        else System.out.println("NO");
    }
}
