class Solution {

    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return dfs(0, false, prices);
    }

    private int dfs(int i, boolean contains, int[] prices){
        if(i >= prices.length) return 0;
        if(dp[i][(contains) ? 1 : 0] != null){
            return dp[i][(contains) ? 1 : 0];
        }
        int skip = dfs(i + 1, contains, prices);

        if(contains){
            int sell = Math.max(dfs(i + 2, false, prices) + prices[i], skip);
            dp[i][1] = sell;
            return sell;
        } else{
            int buy = Math.max(dfs(i + 1, true, prices) - prices[i], skip);
            dp[i][0] = buy;
            return buy;
        }
    }
}