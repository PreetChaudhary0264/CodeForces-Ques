package ImpTemplates;

public class SparseTable {
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,3};
        int[][] sparse = buildSparse(arr);
    }
    private static int[][] buildSparse(int[] arr){
        int maxLog = 1;
        int n = arr.length;
        while((1 << maxLog) <= n)maxLog++;
        int[][] st = new int[maxLog][n];
        //base case => for length 1 startign from each index

        for(int i = 0; i < n; i++){
            st[0][i] = arr[i];
        }
        for(int k = 1; k < maxLog; k++){
            for(int i = 0; i + (1 << k) <= n; i++){
                st[k][i] = Math.max(
                        st[k-1][i],
                        st[k-1][i + (1 << (k-1))]
                );
            }
        }
        return st;
    }
    private static int query(int l,int r,int[][] st){
        int len = r-l+1;

//        int k = 31 - Integer.numberOfLeadingZeros(len);      //int k = log2(len);

        int k = (int)(Math.log(len) / Math.log(2));

        return Math.max(
                st[k][l],
                st[k][r - (1 << k) + 1]
        );
    }
}
