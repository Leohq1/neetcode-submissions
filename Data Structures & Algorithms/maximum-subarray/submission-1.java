class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i : nums){
            cur += i;
            max = Math.max(cur, max);
            if(cur < 0) cur = 0;
        }
        return max;
    }
}
