class Solution {
    Set<String> seen = new HashSet<>();
    char[][] board;
    String word;
    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int index, int r, int c){
        if(index == word.length() - 1){
            return board[r][c] == word.charAt(index);
        }
        seen.add("" + r + "," + c);
        boolean temp = false;
        for(int[] dir : directions){
            int nR = r + dir[0];
            int nC = c + dir[1];
            if(nR >= 0 && nR < board.length && nC >= 0 && nC < board[0].length){
                if(!seen.contains("" + nR + "," + nC) && (index == word.length() - 1 || board[nR][nC] == word.charAt(index + 1))){
                    temp = temp || backtrack(index + 1, nR, nC);
                }
            }
        }
        seen.remove("" + r + "," + c);
        return temp;
    }
}