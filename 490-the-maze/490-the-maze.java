class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return travel(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }
    
    public boolean travel(int[][] maze, int row, int col, int[] dest, boolean[][] visited) {
        
        if(row == dest[0] && col == dest[1]) {
            return true;
        }
        
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length 
                            || visited[row][col] || maze[row][col] == 1) {
            return false;
        }
        
        visited[row][col] = true;
        
        int leftTemp = col;
        while(leftTemp >= 0 && maze[row][leftTemp] != 1) {
            leftTemp--;
        }
        leftTemp++;
        boolean left = travel(maze, row, leftTemp, dest, visited);
        
        int rightTemp = col;
        while(rightTemp < maze[0].length && maze[row][rightTemp] != 1) {
            rightTemp++;
        }
        rightTemp--;
        boolean right = travel(maze, row, rightTemp, dest, visited);
        
        int downTemp = row;
        while(downTemp < maze.length && maze[downTemp][col] != 1) {
            downTemp++;
        }
        downTemp--;
        boolean down = travel(maze, downTemp, col, dest, visited);
        
        int upTemp = row;
        while(upTemp >= 0 && maze[upTemp][col] != 1) {
            upTemp--;
        }
        upTemp++;
        boolean up = travel(maze, upTemp, col, dest, visited);
        
        if(left || right || down || up) {
            return true;
        }
        
        return false;
    }
}


/*

left, right, down, up

*/