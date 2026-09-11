class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, index);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];

        int low = left;
        int i = left;
        int high = right;

        while (i <= high) {
            if (nums[i] < pivot) {
                swap(nums, i, low);
                i++;
                low++;
            } 
            else if (nums[i] > pivot) {
                swap(nums, i, high);
                high--;
            } 
            else {
                i++;
            }
        }

        // [left ... low - 1] < pivot
        // [low ... high]     == pivot
        // [high + 1 ... right] > pivot

        if (k < low) {
            return quickSelect(nums, left, low - 1, k);
        } 
        else if (k > high) {
            return quickSelect(nums, high + 1, right, k);
        } 
        else {
            return pivot;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}