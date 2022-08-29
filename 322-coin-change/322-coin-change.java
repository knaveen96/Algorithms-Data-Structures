//Bottom up
// class Solution {
//     public int coinChange(int[] coins, int amount) {
        
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
        
//         for(int i = 1 ; i <= amount ; i++) {
//             for(int j = 0 ; j < coins.length ; j++) {
                
//                 if(i >= coins[j]) {
                    
//                     dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }






//Top Down
// class Solution {
//     public int coinChange(int[] coins, int amount) {
        
//         if(amount < 1) return 0;
        
//         return minNumberOfCoins(coins, amount, new int[amount+1]);
//     }
    
//   private int minNumberOfCoins(int[] coins, int amount, int[] memo){
        
//         if(amount == 0) return 0;
//         if(amount < 0) return -1;
//         if(memo[amount] != 0) return memo[amount];
        
//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i < coins.length ; i++) {
            
//             int res = minNumberOfCoins(coins, amount-coins[i], memo);
//             if(res >= 0)
//                 min =  Math.min(min, 1 + res);
//         }
        
//         memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
      
//         return memo[amount]; 
//     }
// }



/**
coins = [1,2,5], amount = 11




**/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] memo = new int[amount + 1];
        int val = findMinCoins(coins, amount, memo);
        
        return val == Integer.MAX_VALUE ? -1 : val;
        
    }
    
    private int findMinCoins(int[] coins, int amount, int[] memo) {
        
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != 0) return memo[amount];
                
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < coins.length ; i++) {
            
            int subRes = 1 + findMinCoins(coins, amount - coins[i], 
                                        memo);
            if(subRes > 0)
                min = Math.min(min, subRes);
        }
        
        return memo[amount] = min;            
    }
}



/*  
                        [1,2,5] 
                      amount = 11
                     10    9     6
                    



*/


// class Solution {
    
//     int[] memo;
    
//     public int coinChange(int[] coins, int amount) {
        
//         memo = new int[amount + 1];
//         int res = coinChangeHelper(coins, amount, 0);
        
//         return res == Integer.MAX_VALUE ? -1 : res;
        
//     }
    
//     public int coinChangeHelper(int[] coins, int amount, int currAmount) {
        
//         if(currAmount == amount) {
//             return 0;
//         }
        
//         if(currAmount > amount) {
//             return -1;
//         }
        
//         if(memo[currAmount] != 0) {
//             return memo[currAmount];
//         }
        
//         int minVal = Integer.MAX_VALUE;
        
//         for(int i = 0 ; i < coins.length ; i++) {
            
//             int subRes = 1 + coinChangeHelper(coins, amount, coins[i] + currAmount);
//             if(subRes > 0)
//                 minVal = Math.min(minVal, subRes);
//         }
        
//         return memo[currAmount] = minVal;
//     }
// }

/*

                        [1,2,5] amount = 5
                        
                    1          2          5 
                  1 2 5      1 2 5      1 2 5
                1
              1
              
1 1 1 1 1
1 2 2
5


coins = [1,2], amount = 5

1 2 1    1

2 1 1    1 -> how many more coins to reach the target?

state -> coins, curr sum of the coins present

(or) anyways I am storing the min number of coins resulting to that amount


number of coins

*/










