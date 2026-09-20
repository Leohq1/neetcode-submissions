class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.merge(c, -1, (a, b) -> a + b);
        }
        Queue<Integer> pq = new PriorityQueue<>(map.values());
        map = null;
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int cur = pq.remove();
                if(cur < -1){
                    q.add(new int[]{cur + 1, time + n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.remove()[0]);
            }
        }
        return time;
    }
}