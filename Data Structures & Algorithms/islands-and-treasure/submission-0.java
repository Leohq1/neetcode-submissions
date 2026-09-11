class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.addLast(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] temp = q.removeFirst();
            int r = temp[0];
            int c = temp[1];
            for(int[] dir : directions){
                int nR = r + dir[0];
                int nC = c + dir[1];
                if(nR < grid.length && nR >= 0 &&
                    nC < grid[0].length && nC >= 0 &&
                    grid[nR][nC] == Integer.MAX_VALUE){
                    q.addLast(new int[]{nR, nC});
                    grid[nR][nC] = grid[r][c] + 1;
                }
            }
        }
    }
}
