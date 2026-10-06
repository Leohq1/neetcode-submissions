class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        int result = 0;
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[]{0,0});
        grid[0][0] = 1;
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.removeFirst();
                if(temp[0] == grid.length - 1 && temp[1] == grid[0].length - 1) return result;
                for(int[] dir : directions){
                    int[] cur = {temp[0] + dir[0], temp[1] + dir[1]};
                    if(cur[0] < 0 || cur[0] >= grid.length || cur[1] < 0 || cur[1] >= grid[0].length || grid[cur[0]][cur[1]] == 1) continue;
                    q.addLast(cur);
                    grid[cur[0]][cur[1]] = 1;
                }
            }
        }
        return -1;
    }
}