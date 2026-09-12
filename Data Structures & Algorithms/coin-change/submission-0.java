class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> dp = new HashMap<>(); //amount -> coins
        dp.put(0, 0);
        for(int i = 1; i <= amount; i++){
            for(int c : coins){
                if(dp.containsKey(i - c)){
                    int cur = dp.get(i - c) + 1;
                    dp.merge(i, cur, (a, b) -> Math.min(a, b));
                }
            }
        }
        return dp.getOrDefault(amount, -1);
    }
}