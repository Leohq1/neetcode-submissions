class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, index);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        int p = left;
        int pivot = nums[right];
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        nums[right] = nums[p];
        nums[p] = pivot;

        if(k < p) return quickSelect(nums, left, p - 1, k);
        else if(k > p) return quickSelect(nums, p + 1, right, k);
        else return pivot;
    }
}
