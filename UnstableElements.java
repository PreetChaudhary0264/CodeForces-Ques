import java.util.*;

public class UnstableElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            Map<Integer,Integer> mpp = new HashMap<>();
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                mpp.put(val, mpp.getOrDefault(val,0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            for(int key : mpp.keySet()){
                list.add(mpp.get(key));
            }
            Collections.sort(list);
            int size = list.size();
            long[] sum = new long[size];
            sum[size - 1] = list.get(size - 1);
            for(int i = size - 2; i >= 0; i--){
                sum[i] = sum[i + 1] + list.get(i);
            }
            long ans = 0;
            for(int i = 0; i < size; i++){
                if (i == 0 || !list.get(i).equals(list.get(i - 1))) {
                    long s = sum[i];
                    long svc = size - i;
                    if((k - s) % svc == 0){
                        long S = (k - s) / svc;
                        if(S >= (-list.get(i) + 1)){
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}