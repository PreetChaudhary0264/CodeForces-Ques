import java.util.Scanner;

public class RaeTaylorHarderVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();

            int[] p = new int[n + 1];
            int[] pre = new int[n + 1];
            int[] suf = new int[n + 2];
            int[] sufIdx = new int[n + 2];

            pre[0] = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                pre[i] = Math.min(pre[i - 1], p[i]);
            }

            suf[n + 1] = 0;
            for (int i = n; i >= 1; i--) {
                if(p[i] > suf[i+1]){
                    suf[i] = p[i];
                    sufIdx[i] = i;
                } else {
                    suf[i] = suf[i+1];
                    sufIdx[i] = sufIdx[i+1];
                }
            }

            boolean valid = true;
            for (int i = 2; i <= n; i++) {
                if (pre[i - 1] > suf[i]) {
                    valid = false;
                    break;
                }
            }

            if(!valid) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for(int l = 1; l <= n; ){
                    int r = sufIdx[l];
                    for(int i = l; i < r; i++){
                        System.out.println(p[i] + " " + p[r]);
                    }
                    if (l > 1) {
                        System.out.println(pre[l - 1] + " " + p[r]);
                    }
                    l = r + 1;
                }
            }
        }
    }
}
