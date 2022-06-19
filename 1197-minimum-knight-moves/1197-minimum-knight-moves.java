class Solution {
    public int minKnightMoves(int x, int y) {
        
        int moves = 0;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        x = Math.abs(x);
        y = Math.abs(y);
        
        queue.add(new int[]{0, 0});
        visited.add("0,0");
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++) {
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
            
                if(currX == x && currY == y) {
                    return moves;
                }
            
                for(int[] d : directions) {
                    int newX = currX + d[0];
                    int newY = currY + d[1];

                    String s = newX + "," + newY;

                    if(!visited.contains(s) && newX >= -2 && newY >= -2) {
                        queue.add(new int[]{newX, newY});
                        visited.add(s);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}

/*
- col + 2, row + 1
- col + 1, row + 2
- col - 2, row - 1
- col - 1, row + 1
- col - 1, row - 2
- col + 1, row - 2
- col + 2, row - 1
- col - 1, row + 2

*/