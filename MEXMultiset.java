import java.util.Scanner;

public class MEXMultiset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] freq = new int[n+2];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                if(arr[i] <= n){
                    freq[arr[i]]++;
                }
            }
            int max1 = -1;
            int max2 = -1;
            int max3 = -1;
            for(int i = 0; i < freq.length; i++){
                if(max1 != -1)break;
                if(freq[i] < 1)max1 = i;
            }
            for(int i = 0; i < freq.length; i++){
                if(max2 != -1)break;
                if(freq[i] < 2)max2 = i;
            }
            for(int i = 0; i < freq.length; i++){
                if(max3 != -1)break;
                if(freq[i] < 3)max3 = i;
            }
            if(max2 + max3 < max1 && max2 == 0){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            StringBuilder sb = new StringBuilder(n);
            int[] seen = new int[n + 2];

            boolean case1 = (max2 + max3 >= max1);
            int T = max2 + max3;

            for (int i = 0; i < n; i++) {
                int x = arr[i];
                int c = (x <= n) ? seen[x]++ : 1000;

                if (case1) {
                    if (c == 1 && x < max2) sb.append('B');
                    else if (c == 2 && x < max3) sb.append('C');
                    else sb.append('A');
                } else {
                    if (c == 0 && x < T) sb.append('A');
                    else if (c == 1 && x < max2) sb.append('B');
                    else sb.append('C');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
