class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pointer = 0;

        while(pointer <= right){
            if(nums[pointer] == 1){
                pointer++;
            } else if(nums[pointer] == 0){
                swap(nums, left, pointer);
                left++;
                pointer++;
            } else{
                swap(nums, pointer, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}