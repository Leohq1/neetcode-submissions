class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.merge(i, 1, (a, b) -> a + b);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int i : map.keySet()){
            pq.add(i);
            if(pq.size() > k) pq.remove();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.remove();
        }
        return res;
    }
}