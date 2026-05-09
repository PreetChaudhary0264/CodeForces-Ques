import java.util.*;

public class DivisiblePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            HashMap<Integer, List<Integer>> mpp = new HashMap<>();
            long c = 0;
            for(int i = 0; i < n; i++){
                int rem = a[i] % y;
                mpp.computeIfAbsent(rem,k-> new ArrayList<>()).add(a[i]);
            }
            for(int key : mpp.keySet()){
                List<Integer> list = mpp.get(key);
                HashMap<Integer,Integer> seen = new HashMap<>();
                for(int val : list){
                    int rem = val % x;
                    int req = (x - rem) % x;
                    if(seen.containsKey(req)){
                        c += seen.get(req);
                    }
                    seen.put(rem,seen.getOrDefault(rem,0)+1);
                }
            }
            System.out.println(c);
        }
    }
}
