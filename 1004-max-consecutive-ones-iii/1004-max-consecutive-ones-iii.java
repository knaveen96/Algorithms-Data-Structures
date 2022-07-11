// class Solution {
//     public int longestOnes(int[] nums, int k) {
        
//         int left = 0;
//         int count = k;
//         int res = Integer.MIN_VALUE;
        
//         for(int right = 0 ; right < nums.length ; right++) {
          
//             if(nums[right] == 0) count--;
  
//             while(count < 0) {
//                 if(nums[left] == 0) count++;
//                 left++;
//             }

//             res = Math.max(res, right - left + 1);
//         }
//         return res;   
//     }
// }
/*

[1,1,1,0,0,0,1,1,1,1,0]
         l
                     r
count = 0
update res = 

move left until count becomes greater than 0


*/



class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int longest = 0;
        int left = 0;
        int right = 0;
        
        while(right < nums.length) {
            
            if(nums[right] == 0) {
                k--;
            }
            
            while(k < 0) {
                if(nums[left] == 0) k++;
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
            right++;
        }      
        return longest;
    }
}



/*

 0 1 2 3 4 5 6 7 8 9 10
[1,1,1,0,0,0,1,1,1,1,0]
 i
         j

longest = 4
temp = 0



*/





















