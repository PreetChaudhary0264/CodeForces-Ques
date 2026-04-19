import java.util.Arrays;

//Digit DP ...Q ke acc states vary kr skti hai
class Solution {
    int[][][] memo;
    public int countDigitOne(int n) {
        if(n == 0)return 0;
        memo = new int[11][2][10];
        for(int[][] m : memo){
            for(int[] r : m) Arrays.fill(r,-1);
        }
        return solve(String.valueOf(n),0,1,0);
    }
    private int solve(String n, int idx, int tight, int count){
        if(idx == n.length())return count;

        if(memo[idx][tight][count] != -1)return memo[idx][tight][count];
        int lowerBound = 0;
        int upperBound = (tight == 1) ? n.charAt(idx) - '0' : 9;

        int ans = 0;
        for(int i = lowerBound ; i <= upperBound; i++){
            ans += solve(n, idx + 1, (tight == 1 && i == upperBound) ? 1 : 0, count + ((i == 1) ? 1 : 0));
        }
        return memo[idx][tight][count] = ans;
    }
}
