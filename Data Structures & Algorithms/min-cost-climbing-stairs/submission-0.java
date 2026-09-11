class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 0; i < cost.length; i++){
            if(i + 1 < dp.length) dp[i + 1] = Math.min(dp[i + 1], dp[i] + cost[i]);
            if(i + 2 < dp.length) dp[i + 2] = Math.min(dp[i + 2], dp[i] + cost[i]);
        }
        return dp[dp.length - 1];
    }
}