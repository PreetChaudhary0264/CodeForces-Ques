import java.util.Scanner;

public class VesselsHeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while(test-- > 0){
            int n = sc.nextInt();

            int[] heights = new int[n];
            for(int i = 0; i < n; i++){
                heights[i] = sc.nextInt();
            }

            int[] doubled = new int[2 * n];
            for(int i = 0; i < n; i++){
                doubled[i] = heights[i];
                doubled[i + n] = heights[i];
            }

            int[][] sparse = buildSparseTable(doubled);
            long[] ans = new long[n];

            for(int i = 0; i < n; i++){
                long cost = 0;
                int last = -1;

                int right = (i - 1 + n) % n;
                int j = i;

                while(true){
                    if((j+1)%n == i) break;
                    if(j == i){
                        int left = (j + 1) % n;

                        int mx = queryMax(left, right, n, sparse);

                        last = Math.min(mx, heights[i]);
                        cost += last;
                    }
                    else{
                        if(last > heights[j]){
                            cost += last;
                        }
                        else{
                            int left = (j + 1) % n;

                            int mx = queryMax(left, right, n, sparse);

                            int newLast = Math.min(heights[j], mx);

                            cost += newLast;
                            last = newLast;
                        }
                    }

                    j = (j + 1) % n;

                }

                ans[i] = cost;
            }

            for(int i = 0; i < n; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    static int[][] buildSparseTable(int[] arr) {
        int n = arr.length;

        int maxLog = 1;
        while ((1 << maxLog) <= n) maxLog++;

        int[][] st = new int[maxLog][n];

        for (int i = 0; i < n; i++) {
            st[0][i] = arr[i];
        }

        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[j][i] = Math.max(
                        st[j - 1][i],
                        st[j - 1][i + (1 << (j - 1))]
                );
            }
        }

        return st;
    }

    static int queryMax(int l, int r, int n, int[][] st) {

        if(r < l){
            r += n;
        }

        int len = r - l + 1;
        int k = 31 - Integer.numberOfLeadingZeros(len);

        return Math.max(
                st[k][l],
                st[k][r - (1 << k) + 1]
        );
    }
}
