class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, heights, pacific);
            dfs(heights.length - 1, i, heights, atlantic);
        }
        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, heights, pacific);
            dfs(i, heights[0].length - 1, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < heights.length; r++){
            for(int c = 0; c < heights[0].length; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean){
        ocean[r][c] = true;
        for(int[] direction : directions){
            int dr = direction[0], dc = direction[1];
            if(r + dr < heights.length && r + dr >= 0 && c + dc < heights[0].length &&
                c + dc >= 0 && ocean[r + dr][c + dc] == false &&
                heights[r + dr][c + dc] >= heights[r][c]){
                dfs(r + dr, c + dc, heights, ocean);
            }
        }
    }
}