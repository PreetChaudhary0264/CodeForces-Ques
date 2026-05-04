import java.util.Scanner;

public class ItAllWentSideways {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = 0;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                max = Math.max(max,arr[i]);
            }
            int[] freq = new int[max+1];
            for(int i = 0; i < n; i++){
                int val = arr[i];
                freq[val]++;
            }
            int[] prefix = new int[max+1];
//            long[] prefixSize = new long[max+1];
            for(int i = 1; i < freq.length; i++){
                prefix[i] = prefix[i-1] + freq[i];
                long sum = (long)i * freq[i];
//                prefixSize[i] = sum + prefixSize[i-1];
            }
            long ans = 0;
            for(int i = n-1; i >= 0; i--){
                int val = arr[i-1];
                int towers = prefix[prefix.length-1] - prefix[val] - 1;  //-1 kyuki hmne curr tower ko reduce kr diya
//                long sumOfTowers = prefixSize[prefixSize.length-1] - prefixSize[val];
//                ans = Math.max(ans,sumOfTowers);
            }
            System.out.println(ans);
        }
    }
}
