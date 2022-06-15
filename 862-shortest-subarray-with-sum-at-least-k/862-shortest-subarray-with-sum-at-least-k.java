class Solution {
    public int shortestSubarray(int[] nums, int k) {
     
        Deque<long[]> deque = new LinkedList<>();
        int shortest = Integer.MAX_VALUE;
        long cumSum = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            cumSum += nums[i];
            
            if(cumSum >= k) {
                shortest = Math.min(shortest, i + 1);
            }
            
            long[] curr = new long[]{Long.MIN_VALUE, Long.MIN_VALUE};
            while(!deque.isEmpty() && cumSum - deque.peekFirst()[0] >= k) {
                curr = deque.peekFirst();
                deque.removeFirst();
            }
            
            if(curr[0] != Long.MIN_VALUE)
                shortest =(int) Math.min(shortest, i - curr[1]);
            
            while(!deque.isEmpty() && cumSum <= deque.peekLast()[0]) {
                deque.removeLast();
            }
            
            deque.addLast(new long[]{cumSum, i});
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}


/*

[4,5,3,-8,4,10]  k = 12








[84,-37,32,40,95] 167
     l
              r 
 





*/