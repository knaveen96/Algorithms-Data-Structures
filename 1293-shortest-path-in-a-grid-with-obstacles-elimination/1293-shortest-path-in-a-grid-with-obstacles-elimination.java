class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] DIR = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][][] v = new boolean[m][n][k+1];
        Queue<int[]> q = new LinkedList<>();
        int steps = 0;
        q.offer(new int[]{0,0,k});
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                int[] curr = q.poll();
                if(curr[0] == m-1 && curr[1] == n-1) return steps;
                for(int[] d : DIR) {
                    int i = curr[0]+d[0];
                    int j = curr[1]+d[1];
                    int obs = curr[2];
                    
                    if(i >= 0 && i < m && j >= 0 && j < n) {
                        if(grid[i][j] == 0 && !v[i][j][obs]) {
                            q.offer(new int[]{i,j,obs});
                            v[i][j][obs] = true;
                        }
                        else if(grid[i][j] == 1 && obs > 0 && !v[i][j][obs-1]) {
                            q.offer(new int[]{i,j,obs-1});
                            v[i][j][obs-1] = true;
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
}




// class Solution {
//     public int shortestPath(int[][] grid, int k) {
        
//         int rows = grid.length;
//         int cols = grid[0].length;
//         Queue<int[]> queue = new LinkedList<>();
//         boolean[][][] visited = new boolean[rows][cols][k + 1];
//         int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
//         int level = 0;
//         visited[0][0][k] = true;
        
//         queue.add(new int[]{0, 0, k});
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for(int i = 0 ; i < size ; i++) {
//                 int[] curr = queue.poll();
//                 int currRow = curr[0];
//                 int currCol = curr[1];
                
//                 if(currRow == rows - 1 && currCol == cols - 1) return level;
                
//                 for(int[] dir : directions) {
//                     int newRow = currRow + dir[0];
//                     int newCol = currRow + dir[1];
//                     int newK = curr[2];
                        
//                     if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
//                         continue;
//                     }
//                     if(grid[newRow][newCol] == 0 && !visited[newRow][newCol][newK]) {
//                         queue.add(new int[]{newRow, newCol, newK});
//                         visited[newRow][newCol][newK] = true;
//                     }
//                     if(grid[newRow][newCol] == 1 && newK > 0 && 
//                                 !visited[newRow][newCol][newK - 1]) {
//                         queue.add(new int[]{newRow, newCol, newK - 1});
//                         visited[newRow][newCol][newK - 1] = true;
//                     }
//                 }
//             }
//             level++;
//         }
//         return -1;
//     }
// }

















































