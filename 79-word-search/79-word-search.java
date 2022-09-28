class Solution {
    int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(0, board, word, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int index, char[][] board, String word, int row, int col) {
        if(index == word.length()) return true;  
        if(row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if(word.charAt(index) != board[row][col]) return false;
        
        char temp = board[row][col];
        board[row][col] = '.';
        boolean right = dfs(index + 1, board, word, row, col + 1);
        boolean left = dfs(index + 1, board, word, row, col - 1);
        boolean top = dfs(index + 1, board, word, row - 1, col);
        boolean bottom = dfs(index + 1, board, word, row + 1, col);
        board[row][col] = temp;
        
        if(right || left || top ||  bottom) return true;
        return false;
    }
}