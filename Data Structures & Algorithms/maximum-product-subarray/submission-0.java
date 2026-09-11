class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i]);
        }
        for(int i : nums){
            int temp = max;
            max = Math.max(max * i, Math.max(min * i, i));
            min = Math.min(temp * i, Math.min(min * i, i));
            result = Math.max(result, max);
        }
        return result;
    }
}