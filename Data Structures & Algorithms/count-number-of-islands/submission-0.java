class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(bfs(grid, i, j)) result++;
            }
        }
        return result;
    }

    private boolean bfs(char[][] grid, int r, int c){
        if(grid[r][c] == '0') return false;
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[]{r, c});
        grid[r][c] = '0';
        while(!q.isEmpty()){
            int[] curr = q.removeFirst();
            int tempR = curr[0];
            int tempC = curr[1];
            if(tempR > 0 && grid[tempR - 1][tempC] == '1'){
                q.addLast(new int[]{tempR - 1, tempC});
                grid[tempR - 1][tempC] = '0';
            } 
            if(tempC > 0 && grid[tempR][tempC - 1] == '1'){
                q.addLast(new int[]{tempR, tempC - 1});
                grid[tempR][tempC - 1] = '0';
            }
            if(tempR < grid.length - 1 && grid[tempR + 1][tempC] == '1'){
                q.addLast(new int[]{tempR + 1, tempC});
                grid[tempR + 1][tempC] = '0';
            }
            if(tempC < grid[0].length - 1 && grid[tempR][tempC + 1] == '1'){
                q.addLast(new int[]{tempR, tempC + 1});
                grid[tempR][tempC + 1] = '0';
            }
        }
        return true;
    }
}