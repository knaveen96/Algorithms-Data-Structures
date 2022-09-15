class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int N = costs.length;
        int[] refund = new int[N];
        int totalCost = 0;
        
        for(int i = 0 ; i < N ; i++){
            totalCost += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        
        for(int i = 0 ; i < N/2 ; i++) {
            totalCost += refund[i];
        }
        return totalCost;
    }
}

/*
2n people
cityA - 0, 
cityB -          
                            ^
                    0        1        2        3
                 [[10,20],[30,200],[400,50],[30,20]]
                        
                    10                  20
                30      200        30       200
            400   50    
                        
                    
                        


*/