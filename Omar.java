import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Omar {
    static long MOD = (long) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int minusOne = 0;
            Map<Long, Integer> mpp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                if (val == -1) {
                    minusOne++;
                } else {
                    mpp.put(val, mpp.getOrDefault(val, 0) + 1);
                }
            }
            long twtp = 1;
            for (int val : mpp.values()) {
                twtp = (twtp * powerExpo(2, val - 1)) % MOD;
            }
            long c = 0;
            for (long key : mpp.keySet()) {
                if (mpp.containsKey(key + 1)) {
                    c++;
                }
            }
            long cneg = 0;
            long cpos = 0;
            if (minusOne == 0) {
                cneg = twtp;
                cpos = 0;
            } else {
                long minusOnePicks = powerExpo(2, minusOne - 1);
                cneg = (minusOnePicks * twtp) % MOD;
                cpos = (minusOnePicks * twtp) % MOD;
                cpos = (cpos * c) % MOD;
            }
            long ans = (cneg + cpos) % MOD;
            System.out.println(ans);
        }
    }
    private static long powerExpo(long a, long b) {
        if (b == 0) return 1;
        long half = powerExpo(a, b / 2);
        long res = (half * half) % MOD;

        if (b % 2 != 0) {
            res = (a * res) % MOD;
        }
        return res;
    }
}
