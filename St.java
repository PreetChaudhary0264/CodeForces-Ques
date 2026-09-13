import java.util.ArrayList;
import java.util.Scanner;

public class St {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            ArrayList<Integer> ch = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] != i + 1) {
                    ch.add(i);
                }
            }
            boolean possible = true;
            int k = ch.size();
            for (int j = 0; j < k; j++) {
                if (arr[ch.get(j)] != ch.get(k - 1 - j) + 1) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
