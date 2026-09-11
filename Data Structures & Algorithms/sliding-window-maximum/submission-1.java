class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];

        for(; right < k; right++){
            while(!dq.isEmpty() && nums[right] > nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(right);
        }
        result[left] = nums[dq.getFirst()];

        for(; right < nums.length; right++){
            left++;
            while(!dq.isEmpty() && nums[right] > nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(right);
            while(dq.getFirst() < left){
                dq.removeFirst();
            }
            result[left] = nums[dq.getFirst()];
        }
        return result;
    }
}