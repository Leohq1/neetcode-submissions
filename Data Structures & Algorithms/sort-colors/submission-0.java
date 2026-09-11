class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num : nums){
            count[num]++;
        }
        for(int i = 0; i < nums.length; i++){
            if(i < count[0]) nums[i] = 0;
            else if(i < count[1] + count[0]) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}