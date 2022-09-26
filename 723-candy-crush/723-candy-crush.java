class Solution {
    public int[][] candyCrush(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        boolean flag = false;
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j + 2 < cols ; j++) {
                int curr = Math.abs(board[i][j]);
                if(board[i][j] != 0 && curr == Math.abs(board[i][j+1]) 
                   && curr == Math.abs(board[i][j+2])) {
                    board[i][j] = board[i][j+1] = board[i][j+2] = -curr;
                    flag = true;
                }
            }
        }
        
        for(int i = 0 ; i + 2 < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                int curr = Math.abs(board[i][j]);
                if(board[i][j] != 0 && curr == Math.abs(board[i+1][j]) 
                   && curr == Math.abs(board[i+2][j])) {
                    board[i][j] = board[i+1][j] = board[i+2][j] = -curr;
                    flag = true;
                }
            }
        }
        
//         //crush candies
//         for(int j = 0 ; j < cols ; j++) {
//             int left = 0;
//             int right = rows - 1;
            
//             //move right
//             while(right > 0 && board[right][j] > 0) {
//                 right--;
//             }
//             while(left < rows - 1 && board[left][j] > 0) {
//                 left++;
//             }
//             left--;
//             while(left < right && left >= 0) {
//                 //swap
//                 board[right][j] = board[left][j];
//                 left--;
//                 right--;
//             }  
//             while(right < left) {
//                 board[right--][j] = 0;
//             }
//         }   
        
        
        for (int c = 0; c < cols; ++c) {
            int wr = rows - 1;
            for (int r = rows-1; r >= 0; --r)
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c];
            while (wr >= 0)
                board[wr--][c] = 0;
        }
        if(flag) candyCrush(board);
        return board;
    }
}

/*

- scan rows + tag rows
- scan cols + tag cols
- crush candies

1 2 2 2 2 2 
  l
          r

    0     1     2    3    4 
0  [110,  5,   112, 113, 114]
1  [210,  211, 5,   213, 214]
2  [310,  311, 3,   313, 314]
3  [410,  411, 412, 5,   414]
4  [5,    1,   512, 3,   3]
5  [610,  4,   1,   613, 614]
6  [710,  1,   2.,   713, 714]
7  [810,  1,   2.,   1,   1]
8  [1,    1,   2.,   2.,   2.]
9  [4,    1,   4,   4,   1014]

    0     1     2    3    4 
0  [110,  0,   112,  113, 114]
1  [210,  0  , 5,    213, 214]
2  [310,  0  , 3,    313, 314]
3  [410,  0,    412,  5,   414]
4  [5,    5,    512, 3,   3]
5  [610,  211,  1,   613, 614]
6  [710,  311,  -2.,  713, 714]
7  [810,  411,  -2.,  1,   1]
8  [1,    1,    -2.,  -2.,  -2.]
9  [4,    4,    4,   4,   1014]


c = 0

1   
2
3
4  l
-1
-1
-1 r
9   







1 2 3 4 0 0 0 9 -> 0 0 0 1 2 3 4 9
l
              r 
      
- move left to the last +ve int
- move right to the last -ve int
- swap 
    - left--
    - right--


c1, r6-r9
overlap
r8, c2-c4
c2, r6-r8

crushRows(int col, int startRow, int endRow)  
crushCols(int row, int startCol, int endCol)

- when there are big examples take a small example and try


*/