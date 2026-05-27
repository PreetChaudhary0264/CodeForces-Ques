import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextLong();
            }
            long minDiff = Long.MAX_VALUE;
            List<Long> differences = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = i+1; j  < n; j++){
                    long diff = Math.abs(a[i] - a[j]);
                    differences.add(diff);
                    minDiff = Math.min(minDiff,diff);
                }
            }
            Arrays.sort(a);
            if(k >= 3){
                System.out.println(0);
            }else if(k == 1){
                minDiff = Math.min(minDiff,a[0]);
                System.out.println(minDiff);
            }else{
                for(long d : differences){
                    long least = leastBound(a,d);
                    long upper = upperBound(a,d);

                    if(least != Long.MIN_VALUE){
                        minDiff = Math.min(minDiff, d - least);
                    }

                    if(upper != Long.MAX_VALUE){
                        minDiff = Math.min(minDiff, upper - d);
                    }
                }
                System.out.println(minDiff);
            }
        }
    }
    private static long leastBound(long[] a, long target){
        int l = 0, r = a.length - 1;
        long ans = Long.MIN_VALUE;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(a[mid] <= target){
                ans = a[mid];
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;
    }

    private static long upperBound(long[] a, long target){
        int l = 0, r = a.length - 1;
        long ans = Long.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(a[mid] >= target){
                ans = a[mid];
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return ans;
    }
}
