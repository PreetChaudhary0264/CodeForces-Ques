import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MadaDynasty {
    static final long MOD = 998244353;
    static long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    static long modInverse(long n) {
        return power(n, MOD - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                long val = sc.nextLong();
                arr[i] = val;
            }
            Arrays.sort(arr);
            Map<Long, long[]> mpp = new HashMap<>();
            long[] suffix = new long[n+1];
            long product = 1;
            for(int i = n-1; i >= 0; i--){
                long c = n - i - 1;
                long sum = suffix[i+1];
                if (c > 0) product = (product * c) % MOD;
                mpp.put(arr[i], new long[]{c, sum});
                suffix[i] = (suffix[i+1] + arr[i]) % MOD;
            }
            long ans = 0;
            for(long key : mpp.keySet()){
                long c = mpp.get(key)[0];
                long sum = mpp.get(key)[1];

                if (c > 0) {
                    long ways = (product * modInverse(c)) % MOD;
                    long parentSum = (ways * sum) % MOD;
                    long selfSum = (product * (key % MOD)) % MOD;
                    ans = (ans + parentSum - selfSum + MOD) % MOD;
                }
            }
            System.out.println(ans);
        }
    }
}
