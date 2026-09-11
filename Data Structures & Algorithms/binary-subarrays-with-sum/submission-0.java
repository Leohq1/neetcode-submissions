class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return maxSub(nums, goal) - maxSub(nums, goal - 1);
    }

    private int maxSub(int[] nums, int max){
        if(max < 0) return 0;
        int left = 0, right = 0, sum = 0, result = 0;
        for(; right < nums.length; right++){
            sum += nums[right];
            while(sum > max && left <= right){
                sum -= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}