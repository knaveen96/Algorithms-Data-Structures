// class Solution {
//     public int lengthOfLIS(int[] nums) {
        
//         int len = nums.length;
//         int[] dp = new int[len];
//         dp[len - 1] = 1; 
//         int max = 0; 
//         if(nums.length == 1) return 1;
        
//         for(int i = len - 2 ; i >= 0 ; i--) {
//             for(int j = i + 1 ; j < len ; j++) {
                
//                 if(nums[i] < nums[j] && dp[i] <= dp[j]) {
//                     dp[i] = 1 + dp[j];
//                 }
//             }
//             if(dp[i] == 0) dp[i] = 1;
//             max = Math.max(dp[i],max);
//         }
                    
//         return max;
//     }
// }





// class Solution { 
//     //[0,1,0,3,2,3]
               
//     public int lengthOfLIS(int[] nums) {
//         ArrayList<Integer> sub = new ArrayList<>();//[0,1,2,3]
//         sub.add(nums[0]);
        
//         for (int i = 1; i < nums.length; i++) {
//             int num = nums[i]; 
//             if (num > sub.get(sub.size() - 1)) { //2 > 3
//                 sub.add(num);
//             } else {
//                 int j = binarySearch(sub, num); // ([0,1,2],2)
//                 sub.set(j, num); //
//             }
//         }
        
//         return sub.size();
//     }
    
//     private int binarySearch(ArrayList<Integer> sub, int num) {                                                         //([0,1,3],2)
//         int left = 0;
//         int right = sub.size() - 1;
//         int mid = (left + right) / 2;
        
//         while (left < right) {
//             mid = (left + right) / 2;
//             if (sub.get(mid) == num) {
//                 return mid;
//             }
            
//             if (sub.get(mid) < num) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }
        
//         return left;
//     }
// }


/**
[0,1,0,3,2,3]


[  , , , , , ,   ,1]

[10,9,2,5,3,7,101,18]
               i   j

**/




// class Solution {                
//     public int lengthOfLIS(int[] nums) {
        
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int max = 1;
        
//         for(int i = 1 ; i < nums.length ; i++) {
//             for(int j = 0 ; j < i ; j++) {
                
//                 if(nums[i] > nums[j]) {
//                     int val = dp[j] + 1;
//                     dp[i] = Math.max(dp[i], val);
//                     max = Math.max(max, dp[i]);
//                 } 
//             }
//         }
//         return max;
//     }
// }

/*
   0 1 2 3 4 5  6  7 
 [10,9,2,5,3,7,101,18]    4
                i
             j
 
 [ 1,1,1,2,2,3, 4, 1]
   0 1 2 3 4 5  6  7

[10,9,2,5,3,7,101,18] 




  0  1 2 3 4 5  6  7
 [10,9,2,5,3,7,101,18]
         ^
             ^
 
 [ 1,1,4,3,3,2, 1, 1]
 

*/


// class Solution {                
//     public int lengthOfLIS(int[] nums) {
        
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int max = 1;
        
//         for(int i = nums.length - 2 ; i >= 0 ; i--) {
//             for(int j = nums.length - 1 ; j > i ; j--) {
                
//                 if(nums[i] < nums[j]) {
//                     dp[i] = Math.max(dp[i], 1 + dp[j]);
//                     max = Math.max(dp[i], max);
//                 }
//             }
//         }
//         return max;
//     }
// }




class Solution {                
    public int lengthOfLIS(int[] nums) {
    
        int n = nums.length;
        int[] dp = new int[n];
        int maxVal = 1;
        
        Arrays.fill(dp, 1);
        
        for(int i = 1 ; i < n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                
                if(nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++) maxVal = Math.max(maxVal, dp[i]);
        return maxVal;
    }
}
