class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(mid <= right){
            int temp = nums[mid];
            if(temp == 2){
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
            if(temp == 1){
                mid++;
            }
            if(temp == 0){
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                if(left > mid) mid = left;
            }
        }
    }
}