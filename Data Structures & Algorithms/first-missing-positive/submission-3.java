class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = (nums[i] <= 0) ? nums.length + 1 : nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            record(i, nums);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }

    private void record(int i, int[] nums){
        int index = Math.abs(nums[i]) - 1;
        if(index < 0 || index >= nums.length) return;
        if(nums[index] == 0) nums[index] = -nums.length;
        else nums[index] = (nums[index] > 0) ? -nums[index] : nums[index];
    }
}