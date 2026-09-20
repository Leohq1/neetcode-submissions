class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.merge(c, -1, (a, b) -> a + b);
        }
        Queue<Integer> pq = new PriorityQueue<>(map.values());
        Deque<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int left = pq.remove();
                if(left < -1) q.addLast(new int[]{left + 1, time + n});
            }
            if(!q.isEmpty() && q.getFirst()[1] == time){
                pq.add(q.removeFirst()[0]);
            }
        }
        return time;
    }
}