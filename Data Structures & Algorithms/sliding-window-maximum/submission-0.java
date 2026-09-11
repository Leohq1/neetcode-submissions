class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;

        for(; right < k; right++){
            pq.add(new int[]{nums[right], right});
        }

        result[0] = pq.peek()[0];

        for(; right < nums.length; right++){
            pq.add(new int[]{nums[right], right});
            left++;
            while(pq.peek()[1] < left){
                pq.remove();
            }
            result[left] = pq.peek()[0];
        }
        return result;
    }

}
