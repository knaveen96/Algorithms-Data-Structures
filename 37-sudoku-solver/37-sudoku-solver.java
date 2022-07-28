// class Solution {
//     int rows;
//     int cols;
//     public void solveSudoku(char[][] board) {
        
//         rows = board.length;
//         cols = board[0].length;
//         fillSudoku(board, 0, 0);
//     }
    
//     private boolean fillSudoku(char[][] board, int i, int j) {
        
//         if (j == cols) {
//             j = 0;
//             i = i + 1;
//         }
//         if(i == rows) return true;
        
//         if(board[i][j] != '.') 
//             return fillSudoku(board, i, j + 1);
        
//         for(char k = '1' ; k <= '9' ; k++) {
                
//             if(validateSudoku(board, i, j, k)) {
//                 board[i][j] = k;
//                 boolean solved = fillSudoku(board, i, j + 1);
//                 if(solved) return true;
//                 else board[i][j] = '.';
//             }
//         }
//         return false;
//     }
    
//     private boolean validateSudoku(char[][] board, int i, int j, char val) {
    
//         for(int k = 0 ; k < cols ; k++) {
//             if(board[i][k] == val) 
//                 return false;
//         }
        
//         for(int k = 0 ; k < rows ; k++) {
//             if(board[k][j] == val) 
//                 return false;
//         }
        
//         int boxRow = i / 3;
//         int boxCol = j / 3;
        
//         for (int k = boxRow * 3; k < (boxRow + 1) * 3; k++) {
//             for (int m = boxCol * 3; m < (boxCol + 1) * 3; m++) {
//                 if(board[k][m] == val) return false;
//             }
//         }
//         return true;
//     }
// }

/*


5 3 .   . 7 .   . . .
6 . .   1 9 5   . . .
. 9 8   . . .   . 6 .

8 . .   . 6 .   . . 3
4 . .   8 . 3   . . 1
7 . .   . 2 .   . . 6

. 6 .   . . .   2 8 .
. . .   4 1 9   . . 5
. . .   . 8 .   . 7 9



- whenever there is a . try out values from 1 to 9.
- one a value is tried out validate it's row, column and grid.


8 - 3,0









5 3 .   . 7 .   . . .
6 . .   1 9 5   . . .
. 9 8   . . .   . 6 .

8 . .   . 6 .   . . 3
4 . .   8 . 3   . . 1
7 . .   . 2 .   . . 6

. 6 .   . . .   2 8 .
. . .   4 1 9   . . 5
. . .   . 8 .   . 7 9


*/





class Solution {
    public void solveSudoku(char[][] board) {
        
        backtrack(board, 0, 0);
    }
    
    public boolean backtrack(char[][] board, int row, int col) {
        
        if(col == 9) {
            row = row + 1;
            col = 0;
        }
        
        if(row == 9) {
            return true;
        }
        
        if(board[row][col] != '.') {
            return backtrack(board, row, col + 1);    
        }
        
        for(char c = '1' ; c <= '9' ; c++) {
            if(canInsert(board, c, row, col)) {
                board[row][col] = c;
                boolean val = backtrack(board, row, col + 1);
                if(val) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    
    public boolean canInsert(char[][] board, char c, int row, int col) {
        
        for(int i = 0 ; i < 9 ; i++) {
            if(board[i][col] == c) return false;
        }
        
        for(int i = 0 ; i < 9 ; i++) {
            if(board[row][i] == c) return false;   
        }
        
        int targetRow = row / 3;
        int targetCol = col / 3;
        
        for(int i = targetRow * 3 ; i < (targetRow + 1) * 3 ; i++) {
            for(int j = targetCol * 3 ; j < (targetCol + 1) * 3 ; j++) {
                if(board[i][j] == c) return false; 
            }
        }
        return true;
    }
}




/*









*/













