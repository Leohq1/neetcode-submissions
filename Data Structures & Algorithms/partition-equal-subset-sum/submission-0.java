class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        dp = new Boolean[nums.length][sum / 2 + 1];
        return dfs(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int index, int target){
        if(target == 0){
            return true;
        }
        if(index >= nums.length){
            return false;
        }
        if(target < 0){
            return false;
        }
        if(dp[index][target] != null) return dp[index][target];
        dp[index][target] = dfs(nums, index + 1, target) || dfs(nums, index + 1, target - nums[index]);
        return dp[index][target];
    }
}