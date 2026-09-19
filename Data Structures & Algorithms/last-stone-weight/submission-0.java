class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : stones){
            pq.add(i);
        }
        while(pq.size() > 1){
            int y = pq.remove();
            int x = pq.remove();
            if(x == y) continue;
            pq.add(y - x);
        }
        return (pq.isEmpty()) ? 0 : pq.remove();
    }
}