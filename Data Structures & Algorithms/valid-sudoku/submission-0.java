class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> grids = new HashMap<>();

        for(int i = 0; i < 9; i++){
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
            grids.put(i, new HashSet<>());
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(rows.get(i).contains(board[i][j])){
                        return false;
                    } else{
                        rows.get(i).add(board[i][j]);
                    }
                    if(columns.get(j).contains(board[i][j])){
                        return false;
                    } else{
                        columns.get(j).add(board[i][j]);
                    }
                    if(grids.get(i / 3 * 3 + j / 3).contains(board[i][j])){
                        return false;
                    } else{
                        grids.get(i / 3 * 3+ j / 3).add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
