// class Solution {
//     public int minimumEffortPath(int[][] heights) {
        
//         int rows = heights.length;
//         int cols = heights[0].length;
//         int[][] efforts = new int[rows][cols];
//         int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//         PriorityQueue<int[]> queue = new PriorityQueue<>(
//             (arr1, arr2) -> arr1[0] - arr2[0]);
//         queue.add(new int[]{0 ,0, 0});
        
        
//         for(int i = 0 ; i < rows ; i++) Arrays.fill(efforts[i], Integer.MAX_VALUE);
        
//         while(!queue.isEmpty()) {
//             int[] curr = queue.poll();
//             int dist = curr[0], row = curr[1], col = curr[2];
            
//             if(dist > efforts[row][col]) {
//                 continue;
//             }
//             if(row == rows - 1 && col == cols - 1) {
//                 return dist;
//             }
            
//             for(int[] d : directions) {
//                 int newRow = row + d[0];
//                 int newCol = col + d[1];
                
//                 if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) 
//                     continue;
                
//                 int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] -
//                                                       heights[row][col]));
//                 if(newDist < efforts[newRow][newCol]) {
//                     efforts[newRow][newCol] = newDist;
//                     queue.offer(new int[]{newDist, newRow, newCol});
//                 }
//             }
//         }
//         return 0;
//     }
// }


// class Solution {
//     public int minimumEffortPath(int[][] heights) {
        
//         int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//         int rows = heights.length;
//         int cols = heights[0].length;
//         boolean[][] visited = new boolean[rows][cols];
//         int[][] efforts = new int[rows][cols];
//         PriorityQueue<int[]> queue = new PriorityQueue<>(
//             (arr1, arr2) -> arr1[0] - arr2[0]);
        
//         for(int i = 0 ; i < rows ; i++) 
//             Arrays.fill(efforts[i], Integer.MAX_VALUE);
        
//         queue.add(new int[]{0, 0 ,0});
//         efforts[0][0] = 0;
        
//         while(!queue.isEmpty()) {
//             int[] curr = queue.poll();
//             int dist = curr[0], row = curr[1], col = curr[2];
            
//             if(row == rows - 1 && col == cols - 1) return dist;
             
//             for(int[] d : directions) {
//                 int newRow = row + d[0];
//                 int newCol = col + d[1];
                
//                 if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]) 
//                     continue;
                
//                 int newDist = Math.max(dist, Math.abs(heights[row][col] - 
//                                                       heights[newRow][newCol]));
                
//                 if(newDist < efforts[newRow][newCol]) {
//                     efforts[newRow][newCol] = newDist;
//                     queue.add(new int[]{newDist, newRow, newCol});
//                 }
//             }
//         }
//         return -1;
//     }
// }
















/*


(2,2,3)(1,1,6)

(1,0,2)

- once you remove something from the PQ then for that node the shortest path is done.

*/


class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][] efforts = new int[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (arr1, arr2) -> arr1[2] - arr2[2]);
        
        queue.add(new int[]{0,0,0});
        for(int[] effort : efforts) Arrays.fill(effort, Integer.MAX_VALUE); 
        efforts[0][0] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            int currRow = curr[0];
            int currCol = curr[1];
            int currEffort = curr[2];
            
            if(currRow == m - 1 && currCol == n - 1) return currEffort;
            
            for(int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                
                if(newRow < 0 || newRow >= m || newCol < 0 
                   || newCol >= n) continue;
                
                int newEffort = Math.max(currEffort, 
            Math.abs(heights[newRow][newCol]- heights[currRow][currCol]));
                
                if(newEffort < efforts[newRow][newCol]) {
                    efforts[newRow][newCol] = newEffort;
                    queue.add(new int[]{newRow, newCol, newEffort});
                }
            }
        }
        
        return -1;
    }
}














