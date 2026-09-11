class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int cur = nums[i];
            int tempMax = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < cur){
                    tempMax = Math.max(tempMax, dp[j] + 1);
                }
            }
            dp[i] = tempMax;
            result = Math.max(result, tempMax);
        }
        return result;
    }
}

/*nums = [9,1,6,2,3,3,7] length: 7
result = 1
dp = [1, 1, 2]

i = 2
cur = 6
tempMax = 2

j = 1
*/