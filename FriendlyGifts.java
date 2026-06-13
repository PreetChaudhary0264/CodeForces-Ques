import java.util.*;

public class FriendlyGifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[][] mini = new int[n][n/2 + 3];
            for(int[] r : mini)Arrays.fill(r,-1);
            for(int i = 0; i < n; i++){
                int max = a[i];
                int min = a[i];
                boolean[] visited = new boolean[n + 3];
                visited[a[i]] = true;
                for(int j = i; j < n; j++){
                    if(j > i){
                        if(visited[a[j]])break;
                        visited[a[j]] = true;
                        max = Math.max(max,a[j]);
                        min = Math.min(min,a[j]);
                    }
                    int len = j - i + 1;
                    if(len > n/2)break;

                    if(len - 1 == (max-min)){
                        mini[i][len] = min;
                    }
                }
            }
            ArrayList<Integer>[] same = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                 same[i] = new ArrayList<>();
            }
            int ans = 0;
            outer : for(int len = n/2; len >= 1; len--){

                for(int i = 0; i <= n; i++)same[i].clear();

                for(int i = 0; i < n; i++){
                    if(mini[i][len] != -1)same[mini[i][len]].add(i);
                }

                for(int i = 0; i <= n-len; i++){
                    int minValue = mini[i][len];
                    if (minValue == -1) continue;
                    int nextMin = minValue + len;
                    if(nextMin <= n){
                        for(int idx : same[nextMin]){
                            if(i >= idx + len || idx >= i + len){
                                ans = len;
                                break outer;
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
