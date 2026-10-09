class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        int distance = nums[0];
        for(int i = 0; i <= nums[0]; i++){
            if(i >= nums.length) return 1;
            dp[i] = 1;
        }
        distance++;
        for(int i = 1; i < nums.length; i++){
            while(distance < nums.length && distance <= i + nums[i]){
                dp[distance] = dp[i] + 1;
                distance++;
            }
        }
        return dp[dp.length - 1];
    }
}