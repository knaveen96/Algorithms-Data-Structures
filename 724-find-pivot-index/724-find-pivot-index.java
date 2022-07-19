class Solution {
    public int pivotIndex(int[] nums) {
        
        int left = 0, right = 0;
        
        for(int num : nums) {
            right += num;
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            int currNum = nums[i];
            if(i != 0) {
                left += nums[i - 1];
            }
            right -= currNum; 
            
            if(left == right) {
                return i;
            }
            
        }
        return -1;
    }
}

/*

 0 1 2 3 4 5
[1,7,3,6,5,6]
   ^
 

left = 1 + 7 = 8 
right = 27 - 7 = 20 = 17

 
total = 28
set = {27, }

*/