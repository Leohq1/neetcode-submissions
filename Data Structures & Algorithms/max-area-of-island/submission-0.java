class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int ROW = grid.length, COL = grid[0].length;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}