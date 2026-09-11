class KthLargest {
    private Queue<Integer> pq = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int cur : nums){
            pq.add(cur);
            if(pq.size() > k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */