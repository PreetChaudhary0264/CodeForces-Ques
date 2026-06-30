import java.util.Scanner;

public class AlternateWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            boolean valid = true;
//            int prevChanged = 0;
//            int prevChangedIdx = -1;
            if(n == 1 && a[0] > b[0]){
                System.out.println("No");
                continue;
            }
            for(int i = 0; i < n; i++){
                if(i == n-1){
                    if(a[i] > b[i]){
                        valid = false;
                    }
//                    if(a[i] < b[i]){
//                        if(prevChangedIdx != n-2 || (b[i] - a[i]) != prevChanged)valid = false;
//                    }else{
//                        valid = false;
//                    }
                }else
                    if(a[i] != b[i]){
                    if(a[i] > b[i]) {
                        valid = false;
                        break;
                    }
                    int diff = b[i] - a[i];
                    a[i] += diff;
                    if(a[i+1] > b[i+1]){
                        a[i+1] -= diff;
//                        prevChanged = diff;
//                        prevChangedIdx = i+1;
                    }
                }
            }
            if(valid) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
