class Solution {
    public int climbStairs(int n) {
        int[] dp = {1, 2};
        int cur = 2;
        for(; cur < n; cur++){
            dp[cur % 2] = dp[0] + dp[1];
        }
        return dp[(n - 1) % 2];
    }
}
