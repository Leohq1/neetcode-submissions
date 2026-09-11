class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
            grid[r][c] = '0';
        } else{
            return;
        }

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}