import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KefaAndWatch {
    static int n;
    static long[] seg;
    static long[] lazy;
    static final int MAX = 100005;
    static final long MOD = 1000000007;
    static final long BASE = 91138233; // since digits (0-9), 10 ya 31 bhi le sakte

    static long[] pow = new long[MAX];
    static long[][] hashC = new long[10][MAX]; // hash for digit c

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seg = new long[4*n];
        lazy = new long[4*n];
        int m = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        List<List<Integer>> queries = new ArrayList<>();
        for(int i = 0; i < m+k; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                list.add(sc.nextInt());
            }
            queries.add(new ArrayList<>(list));
        }
        precompute();
        build(0, n-1, 0, s);
        Arrays.fill(lazy,-1);

        for(List<Integer> query : queries){
            int a = query.get(0), l = query.get(1)-1,r = query.get(2)-1,b = query.get(3);
            if(a == 1){
                update(0,n-1,0,l,r,b);
            }else{
                if(l > r - b){
                    System.out.println("YES");
                    continue;
                }

                long hash1 = query(0,n-1,0,l,r-b);
                long hash2 = query(0,n-1,0,l+b,r);

                if(hash2 == hash1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    private static void update(int start,int end,int i,int l,int r,int value){

        if(lazy[i] != -1){
            int len = end - start + 1;
            seg[i] = hashC[(int)lazy[i]][len];
            if(start != end){
                lazy[2*i+1] = lazy[i];
                lazy[2*i+2] = lazy[i];
            }
            lazy[i] = -1;
        }

        // case1 = out of bound
        if(l > end || r < start)return;

        //case2 = range me hai
        if(l <= start && end <= r){
            int len = end - start + 1;
            seg[i] = hashC[value][len];
            if(start != end){
                lazy[2*i+1] = value;
                lazy[2*i+2] = value;
            }
            return;
        }

        //case-3  overlapping
        int mid = start + (end - start) / 2;
        update(start,mid,2*i+1,l,r,value);
        update(mid+1,end,2*i+2,l,r,value);

        int rightLength = end - mid;
        seg[i] = (seg[2*i+1] * pow[rightLength] + seg[2*i+2]) % MOD;
    }

    static long query(int start, int end, int i, int l, int r) {

        // push lazy first
        if (lazy[i] != -1) {
            int c = (int)lazy[i];
            int len = end - start + 1;

            seg[i] = hashC[c][len];

            if (start != end) {
                lazy[2*i+1] = c;
                lazy[2*i+2] = c;
            }
            lazy[i] = -1;
        }

        //no overlap
        if (end < l || start > r) return 0;

        // complete overlap
        if (l <= start && end <= r) {
            return seg[i];
        }

        // partial overlap
        int mid = (start + end) / 2;

        long leftHash = query(start, mid, 2*i+1, l, r);
        long rightHash = query(mid+1, end, 2*i+2, l, r);

        // IMPORTANT: right length kitna lena?
        int rightLen = Math.max(0, Math.min(end, r) - Math.max(mid+1, l) + 1);

        return (leftHash * pow[rightLen] + rightHash) % MOD;
    }


    static void precompute() {
        //powers
        pow[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow[i] = (pow[i - 1] * BASE) % MOD;
        }

        //hash for repeated digit c
        for (int c = 0; c <= 9; c++) {
            hashC[c][0] = 0;

            for (int len = 1; len < MAX; len++) {
                // append c at end
                hashC[c][len] = (hashC[c][len - 1] * BASE + (c+1)) % MOD;
            }
        }
    }

    static void build(int start, int end, int i, String s){
        if(start == end){
            int digit = s.charAt(start) - '0' + 1;
            seg[i] = digit;
            return;
        }

        int mid = (start + end) / 2;
        build(start, mid, 2*i+1, s);
        build(mid+1, end, 2*i+2, s);

        int rightLen = end - mid;
        seg[i] = (seg[2*i+1] * pow[rightLen] + seg[2*i+2]) % MOD;
    }
}
