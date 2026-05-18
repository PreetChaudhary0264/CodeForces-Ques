import java.util.Scanner;

public class BoxFitting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] freq = new int[21];
            for(int i = 0; i < n; i++){
                int v = sc.nextInt();
                freq[Integer.numberOfTrailingZeros(v)]++;
            }
            int usedRect = 0;
            int height = 0;
            while(usedRect < n){
                int width = w;

                for(int i = 20; i >= 0; i--){
                    while(freq[i] > 0 && (1 << i) <= width){
                        freq[i]--;
                        usedRect++;
                        width -= (1 << i);
                    }
                }
                height++;
            }
            System.out.println(height);
        }
    }
}
