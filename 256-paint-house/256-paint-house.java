class Solution {
    
    Integer[][] memo;
    
    public int minCost(int[][] costs) {
        
        memo = new Integer[costs.length][3];
        return paintHouses(costs, 0, -1);
        
    }
    
    public int paintHouses(int[][] costs, int index, int prev) {
        
        if(index >= costs.length) {
            return 0;
        }
        
        if(prev != -1) {
            if(memo[index][prev] != null) {
                return memo[index][prev];
            }
        }
        
        
        int minCost = Integer.MAX_VALUE;
        int[] curr = costs[index];
        
        for(int i = 0 ; i < 3 ; i++) {
             if(i != prev) {
                minCost = Math.min(minCost, curr[i] + paintHouses(costs, index + 1, i));
            }
        }
        
        return prev != -1 ? memo[index][prev] = minCost : minCost;
    }
}
                             

/*

- red, blue, green

costs = [[17,2,17],[16,16,5],[14,3,19]]

                  0 1 2    0  1  2   0  1 2
                [17,2,17],[16,16,5],[14,3,19]
                
             17                 2                17
           
           [16,16,5]
           
        
    
    for(int i = 0 ; i < 3 ; i++) {
           
        }
    
    
    

*/