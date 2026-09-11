class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        while(buy < prices.length - 1){
            while(sell < prices.length - 1 && prices[sell] < prices[sell + 1]){
                sell++;
            }
            profit += prices[sell] - prices[buy];
            sell++;
            buy = sell;
        }
        return profit;
    }
}