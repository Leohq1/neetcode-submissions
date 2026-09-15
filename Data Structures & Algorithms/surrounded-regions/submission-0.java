class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        Deque<int[]> q = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                q.addLast(new int[]{i, 0});
            }
            if(board[i][board[0].length - 1] == 'O'){
                q.addLast(new int[]{i, board[0].length - 1});
            }
        }
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                q.addLast(new int[]{0, i});
            }
            if(board[board.length - 1][i] == 'O'){
                q.addLast(new int[]{board.length - 1, i});
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            int i = cur[0];
            int j = cur[1];
            if(board[i][j] != 'O') continue;
            board[i][j] = 'o';
            for(int[] dir : directions){
                int r = i + dir[0];
                int c = j + dir[1];
                if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O'){
                    q.addLast(new int[]{r, c});
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = (board[i][j] == 'o') ? 'O' : 'X';
            }
        }
    }
}