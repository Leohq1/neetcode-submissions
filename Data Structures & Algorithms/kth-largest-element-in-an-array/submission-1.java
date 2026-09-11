class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());
        for(int i = 0; i < nums.length - k; i++){
            pq.poll();
        }
        return pq.poll();
    }
}