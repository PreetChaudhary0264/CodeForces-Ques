import java.util.Scanner;

public class ScheduleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] freq = new int[n];
            for(int i = 0; i < m; i++){
                int val = sc.nextInt() - 1;
                freq[val]++;
            }
            int l = 0;
            int h = 2 * m;
            int ans = 0;
            while(l <= h){
                int mid = l + (h - l) / 2;
                if(check(freq,mid,m)){
                    ans = mid;
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    private static boolean check(int[] freq,int time,int m){
        long maxTasks = 0;
        for(int i = 0; i < freq.length; i++){
            if(time < freq[i]){
                maxTasks += time;
            }else{
                maxTasks += freq[i] + ((time - freq[i]) / 2);
            }
        }
        return maxTasks >= m;
    }
}
