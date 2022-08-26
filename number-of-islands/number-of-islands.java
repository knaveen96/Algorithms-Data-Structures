class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, rows, cols, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void dfs(char[][] grid, int rows, int cols, int cRow, int cCol) {
        
        if(cRow < 0 || cRow >= rows || cCol < 0 || cCol >= cols || grid[cRow][cCol] == '0') return;
        
        grid[cRow][cCol] = '0';
        
        dfs(grid, rows, cols, cRow + 1, cCol);
        dfs(grid, rows, cols, cRow - 1, cCol);
        dfs(grid, rows, cols, cRow, cCol + 1);
        dfs(grid, rows, cols, cRow, cCol - 1);
        
    }
}