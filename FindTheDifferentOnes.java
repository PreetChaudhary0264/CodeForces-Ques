import java.util.ArrayList;
import java.util.Scanner;

public class FindTheDifferentOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)a[i] = sc.nextInt();
            int q = sc.nextInt();
            ArrayList<int[]> queries = new ArrayList<>();
            for(int i = 0; i < q; i++){
                queries.add(new int[]{sc.nextInt(),sc.nextInt()});
            }
            int[] lstDiffIdx = new int[n];
            int lastIdx = -1;
            lstDiffIdx[0] = -1;
            for(int i = 1; i < n; i++){
                if(a[i] != a[i-1]){
                    lastIdx = i-1;
                }
                lstDiffIdx[i] = lastIdx;
            }
            for(int[] query : queries){
                int l = query[0]-1;
                int r = query[1]-1;
                if(lstDiffIdx[r] >= l){
                    System.out.println((lstDiffIdx[r] + 1) + " " + (r + 1));
                }else{
                    System.out.println("-1 -1");
                }
                System.out.println();
            }
        }
    }
}
