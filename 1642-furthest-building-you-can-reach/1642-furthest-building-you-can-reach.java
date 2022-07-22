class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> ladderQueue = new PriorityQueue<>(
            (a, b) -> a - b);
        
        for(int i = 0 ; i < heights.length - 1; i++) {
            
            int distance = heights[i + 1] - heights[i];
            
            if(distance <= 0) {
                continue;
            }
            ladderQueue.add(distance);
            
            if(ladderQueue.size() <= ladders) {
                continue;
            }
            bricks = bricks - ladderQueue.poll();
            
            if(bricks < 0) return i;
            
        }
        return heights.length - 1;
    }
}

/*

h[i + 1] - h[i] bricks or ladder to move from one to other

heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1

 0 1 2 3 4 5 6 7 
[4,2,7,6,9,14,12]
         ^


heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2

 0  1 2 3 4 5  6  7 8 
[4,12,2,7,3,18,20,3,19]
          ^
 
bricks = 10, ladders = 0

heights = [14,3,19,3], bricks = 17, ladders = 0


*/