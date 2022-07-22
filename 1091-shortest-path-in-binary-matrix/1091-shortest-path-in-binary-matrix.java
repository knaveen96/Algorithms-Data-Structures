class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int M = grid.length;
        int N = grid[0].length;
        if(grid[0][0] != 0 || grid[M-1][N-1] != 0)
            return -1;
        if(M == 1 && N == 1) return 1;
        Queue<int[]> queue = new LinkedList<>(); //[0,1]
        queue.add(new int[]{0,0});
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},                                                           {1,0},{1,1}};
        int len = 0; //1
        grid[0][0] = -1;
        
        while(!queue.isEmpty()) {
            int size = queue.size(); //1
            len++;
            for(int k = 0 ; k < size ; k++) { //0
                int i = queue.peek()[0];//0
                int j = queue.peek()[1];//0
                queue.poll();
                //grid[i][j] = -1;
                
                for(int[] d : dir) {
                    int r = i + d[0];//0
                    int c = j + d[1];//1
                      
                    if(r < 0 || c < 0 || r >= M || c >= N || 
                       grid[r][c] != 0) {
                        continue;
                    }
                    if(r == M - 1 && c == N - 1) {
                        len++;
                        return len;
                    }
                    
                    queue.add(new int[]{r, c});
                    grid[r][c] = -1;
                }
            }
        }
        
        return -1;
    }
}



/*
1 0 0 
1 1 0
1 1 0

len = 0
size = 1
queue -> [0,0]


*/









    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    













