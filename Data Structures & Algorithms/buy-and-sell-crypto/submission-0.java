class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for(int cur : prices){
            buy = Math.min(cur, buy);
            profit = Math.max(cur - buy, profit);
        }

        return profit;
    }
}
