class Solution {
    public int rob(int[] nums) {
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob1(nums, 0, nums.length - 1), rob1(nums, 1, nums.length));
    }

    private int rob1(int[] nums, int start, int end){
        if(nums.length == 1) return nums[0];
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start + 1], nums[start]);
        int cur = prev1;
        for(int i = start + 2; i < end; i++){
            cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}