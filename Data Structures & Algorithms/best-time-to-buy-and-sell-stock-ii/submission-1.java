class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int profit = 0;
        while(buy < prices.length - 1){
            profit += (prices[sell] > prices[buy]) ? prices[sell] - prices[buy] : 0;
            buy++;
            sell++;
        }
        return profit;
    }
}