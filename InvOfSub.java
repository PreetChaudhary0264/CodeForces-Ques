import java.util.Scanner;

public class InvOfSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int[] b = new int[n];
            for(int i = 0; i < n; i++)b[i] = sc.nextInt();
            int oo = 0;
            int zz = 0;
            int oz = 0;
            int zo = 0;
            for(int i = 0; i < n; i++){
                if(a[i] != b[i]){
                    if(a[i] == 0)zo++;
                    else oz++;
                }else{
                    if(a[i] == 1)oo++;
                    else zz++;
                }
            }
            if(oz == 0 && zo == 0) System.out.println(0);
            else if(oz % 2 != 0) System.out.println(1);
            else if(oz == 0 && !(oo >= 1 && zz >= 1)) System.out.println(-1);
            else System.out.println(2);
        }
    }
}
