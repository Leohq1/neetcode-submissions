class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> distance(b[0], b[1]) - distance(a[0], a[1]));
        for(int[] cur : points){
            pq.add(cur);
            if(pq.size() > k) pq.remove();
        }
        int[][] result = new int[pq.size()][2];
        int size = pq.size();
        for(int i = 0; i < size; i++){
            result[i] = pq.remove();
        }
        return result;
    }

    private int distance(int x, int y){
        return x * x + y * y;
    }
}