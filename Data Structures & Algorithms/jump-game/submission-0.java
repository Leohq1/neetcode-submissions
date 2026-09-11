class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(target - i <= nums[i]){
                target = i;
            }
        }
        return target == 0;
    }
}