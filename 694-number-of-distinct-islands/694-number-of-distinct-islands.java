class Solution {
    
    int rows;
    int cols;
    Set<String> set;
    int baseRow;
    int baseCol;
    
    public int numDistinctIslands(int[][] grid) {
        
        rows = grid.length;
        cols = grid[0].length;
        set = new HashSet<>();
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                
                if(grid[i][j] == 1) {
                    baseRow = i;
                    baseCol = j;
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int row, int col, int[][] grid, StringBuilder sb) {
        
        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return;
        }
        
        sb.append(row - baseRow);
        sb.append(col - baseCol);
        
        grid[row][col] = 0;
        
        dfs(row + 1, col, grid, sb);
        dfs(row - 1, col, grid, sb);
        dfs(row, col + 1, grid, sb);
        dfs(row, col - 1, grid, sb);
        
    }
    
}



/*
- use a hash kind of mechanism

*/