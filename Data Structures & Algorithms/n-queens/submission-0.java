class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n]; //0 -> empty, 1 -> queen, -1 -> could attack(number of q that could attack)
        backtrack(board, 0, n);
        return result;
    }

    private void backtrack(int[][] board, int num, int target){
        if(num == target){
            List<String> validBoard = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder cur = new StringBuilder();
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] <= 0){
                        cur.append(".");
                    } else{
                        cur.append("Q");
                    }
                }
                validBoard.add(cur.toString());
            }
            result.add(validBoard);
            return;
        }

        for(int j = 0; j < board[0].length; j++){
            if(board[num][j] == 0){
                markAttack(board, num, j);
                backtrack(board, num + 1, target);
                eraseAttack(board, num, j);
            }
        }
    }
    private void eraseAttack(int [][] board, int i, int j){
        board[i][j] = 0;
        for(int r = 0; r < board.length; r++){
            if(board[r][j] < 0) board[r][j]++;
        }
        for(int c = 0; c < board.length; c++){
            if(board[i][c] < 0) board[i][c]++;
        }
        int row;
        int col;
        if(i - j > 0){
            row = i - j;
            col = 0;
        } else{
            row = 0;
            col = j - i;
        }
        while(row < board.length && col < board[0].length){
            if(board[row][col] < 0) board[row][col]++;
            row++;
            col++;
        }
        if(board.length - 1 - i - j > 0){
            row = i + j;
            col = 0;
        } else{
            row = board.length - 1;
            col = j - (board.length - i - 1);
        }
        while(row >= 0 && col < board[0].length){
            if(board[row][col] < 0) board[row][col]++;
            row--;
            col++;
        }
    }
    private void markAttack(int[][] board, int i, int j){
        board[i][j] = 1;
        for(int r = 0; r < board.length; r++){
            if(board[r][j] <= 0) board[r][j]--;
        }
        for(int c = 0; c < board.length; c++){
            if(board[i][c] <= 0) board[i][c]--;
        }
        int row;
        int col;
        if(i - j > 0){
            row = i - j;
            col = 0;
        } else{
            row = 0;
            col = j - i;
        }
        while(row < board.length && col < board[0].length){
            if(board[row][col] <= 0) board[row][col]--;
            row++;
            col++;
        }
        if(board.length - 1 - i - j > 0){
            row = i + j;
            col = 0;
        } else{
            row = board.length - 1;
            col = j - (board.length - i - 1);
        }
        while(row >= 0 && col < board[0].length){
            if(board[row][col] <= 0) board[row][col]--;
            row--;
            col++;
        }
    }
}