import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WeirdSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] rows = new ArrayList[100006];
        ArrayList<Integer>[] cols = new ArrayList[100006];
        for(int i = 0; i <= 100005; i++){
            rows[i] = new ArrayList<>();
            cols[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int val = sc.nextInt();
                rows[val].add(i);
                cols[val].add(j);
            }
        }
        long ans = 0;
        for(int i = 0; i <= 100005; i++){
            if(rows[i].isEmpty())continue;
            ans += solve(rows[i]);
            ans += solve(cols[i]);
        }
        System.out.println(ans);
    }
    private static long solve(ArrayList<Integer> list){
        Collections.sort(list);
        long ans = 0;
        int n = list.size();
        long prefixSum = 0;
        for(int i = 0; i < n; i++){
            ans += ((long) i * list.get(i)) - prefixSum;
            prefixSum += list.get(i);
        }
        return ans;
    }
}
