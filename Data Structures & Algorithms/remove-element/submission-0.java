class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = nums.length;
        int left = 0;
        while(left < pointer){
            if(nums[left] == val){
                pointer--;
                swap(nums, left, pointer);
            } else{
                left++;
            }
        }
        return left;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}